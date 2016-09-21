(function() {
    'use strict';

    angular.module('app.dictionary').controller('DictionaryController', DictionaryController);

	DictionaryController.$inject = ['$scope' ,"DictionaryService" , "routerHelper" , "Pagination","formValidator"];

    function DictionaryController($scope , DictionaryService , routerHelper , Pagination,formValidator) {
        var vm = this;
        vm.formValidator = formValidator;

        vm.codes = [];
        vm.code = {};
        
        vm.codeQuery = {};
        
        vm.s="10";
        $(".is-edit").attr("disabled",true);
        
        init();

        function init() {
        	refresh();
        }
        
        function refresh( p,s){
    		var codeType = vm.codeQuery.codeType;
    		var description = vm.codeQuery.description;
    		var codeName = vm.codeQuery.codeName;
            var promise = DictionaryService.getCodesWithPage( p || 1,s || 10,codeType || "",description || "",codeName || "");
            promise.then(function(codes) {
                vm.codes = codes;
            });
        }
        
        vm.paginationHandler = function(){
            if( vm.codes) {
                return Pagination.create( vm.codes  , function(index){
                    refresh(index,vm.s);
                });
            }
        }
        vm.pageNumHandler = function(s){
        	refresh(1,s);
        }
        
        vm.queryCode = function(){
        	$(".is-edit").attr("disabled",true);
        	vm.code = {};//清空表单数据
        	refresh();
        }
        
        vm.chooseRow = function(row){
        	$(".is-edit").attr("disabled",true);
        	vm.code = row;
        }
        
        vm.deleteModal = function() {
        	if(vm.code.id!=0 && (vm.code.id=="" || !vm.code.id)){
        		$.smallBox({
        			title : "提示" ,
        			content : "请选择一条数据"  ,
        			timeout : 5000 ,
        		} , function(){});
        		return;
        	}
        	$('#delModal').modal();  
        }
        vm.deleteCode = function(){
        	var promise = DictionaryService.delCodes(vm.code.id);
            promise.then(function() {
            	$.smallBox({
        			title : "提示" ,
        			content : "删除成功"  ,
        			timeout : 1000 ,
        		} , function(){
        			vm.code = {};//清空表单数据
        			refresh();
        		});
            });
        }
        
        vm.addCode = function(){
        	vm.code = {};//清空表单数据
        	$(".help-block").attr("ng-show",false);
        	$(".is-edit").attr("disabled",false);
        }
        
        vm.editCode = function(){
        	if(vm.code.id!=0 && (vm.code.id=="" || !vm.code.id)){
        		$.smallBox({
        			title : "提示" ,
        			content : "请选择一条数据"  ,
        			timeout : 5000 ,
        		} , function(){});
        		return;
        	}
        	$(".is-edit").attr("disabled",false);
        }
        
        vm.saveCode = function(){
        	if($("#codeType").attr("disabled")){//详细信息出于不可编辑状态
        		return;
        	}
        	var result = checkDetail();//检验输入项
        	if(result!=""){
        		$.smallBox({
                    title : "提示" ,
                    content : result  ,
                    timeout : 5000 ,
                } , function(){});
        		return;
        	}
        	var successTip = "";
        	if(vm.code.id!=0 && (vm.code.id=="" || !vm.code.id)){
        		var promise = DictionaryService.addCodes(vm.code);//新增
        		successTip = "新增成功";
        	}else{
        		var promise = DictionaryService.updateCodes(vm.code)//更新
        		successTip = "保存成功";
        	}
        	promise.then(function(message) {
            	if(message==""){
            		$.smallBox({
            			title : "提示" ,
            			content : successTip  ,
            			timeout : 1000 ,
            		} , function(){
            			vm.code = {};//清空表单数据
            			$(".is-edit").attr("disabled",true);
            			refresh();
            		});
            	}else{
            		$.smallBox({
            			title : "提示" ,
            			content : message  ,
            			timeout : 5000 ,
            		} , function(){});
            	}
            });
        }
        
        //编辑区验证
        function checkDetail(){
        	var result = "";
        	var reg = /^[A-Za-z0-9_]+$/;
        	if(vm.code.codeType=="" || !vm.code.codeType){
        		result = result + "请输入类型";
        	}else if(vm.code.description=="" || !vm.code.description){
        		result = result + "请输入描述";
        	}else if(vm.code.codeName=="" || !vm.code.codeName){
        		result = result + "请输入名称";
        	}else if(!reg.test(vm.code.codeType)){
        		result = result + "类型只能输入字母、数字、下划线";
        	}
        	return result;
        }
        
    }
})();
