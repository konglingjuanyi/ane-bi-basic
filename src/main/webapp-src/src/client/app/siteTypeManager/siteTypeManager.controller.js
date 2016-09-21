(function() {
    'use strict';

    angular.module('app.siteTypeManager').controller('SiteTypeManagerController', SiteTypeManagerController);

    SiteTypeManagerController.$inject = ['$scope' ,"SiteTypeManagerService" , "routerHelper" , "Pagination"];

    function SiteTypeManagerController($scope ,SiteTypeManagerService , routerHelper , Pagination) {
        var vm = this;
//        vm.formValidator = formValidator;
        
        vm.queryData = {};//查询条件
        vm.editData = {};//详细信息
        vm.queryResult = [];//查询结果
        vm.s="10";
        $(".is-edit").attr("disabled",true);
        vm.clfcType = [];//分拨类型
        vm.clfcDtld = [];//分拨功能

        init();

        function init() {
        	refresh();
        	initClfcType();//初始化分拨类型
        	initClfcTdld();//初始化分拨功能
        }
        
        function refresh(p,s){
        	var siteName = vm.queryData.siteName;
        	var statFlag = vm.queryData.stat_flag
            var promise = SiteTypeManagerService.getDataWithPage( p || 1,s || 10,siteName || "",statFlag || "");
            promise.then(function(pageData) {
                vm.queryResult = pageData;
            });
        }
        
        function initClfcType(){
        	var promise = SiteTypeManagerService.getCodesByType("clfc_type");
            promise.then(function(temp) {
                vm.clfcType = temp;
            });
        }
        
        function initClfcTdld(){
        	var promise = SiteTypeManagerService.getCodesByType("clfc_tdld");
            promise.then(function(temp) {
                vm.clfcDtld = temp;
            });
        }
        
        vm.chooseRow = function(row){
        	$(".is-edit").attr("disabled",true);
        	vm.editData = row;
        }
        
        vm.paginationHandler = function(){
            if( vm.queryResult) {
                return Pagination.create( vm.queryResult  , function(index){
                    refresh(index,vm.s);
                });
            }
        }
        vm.pageNumHandler = function(s){
        	refresh(1,s);
        }
        
        vm.query = function(){
        	refresh();
        	$(".is-edit").attr("disabled",true);
        	vm.editData = {};
        }
        
        vm.edit = function(){
        	var id = vm.editData.org_brnch_id;
        	if(id!=0 && (id=="" || !id)){
        		$.smallBox({
        			title : "提示" ,
        			content : "请先选择一条数据"  ,
        			timeout : 5000 ,
        		} , function(){});
        		return;
        	}
        	$(".is-edit").attr("disabled",false);
        }

        vm.save = function(){
        	var id = vm.editData.org_brnch_id;
        	if(id!=0 && (id=="" || !id)){
        		$.smallBox({
        			title : "提示" ,
        			content : "请选择一条数据，编辑后保存"  ,
        			timeout : 5000 ,
        		} , function(){});
        		return;
        	}
        	var promise = SiteTypeManagerService.updateOrgBrnchClfc(vm.editData);
            promise.then(function(message) {
            	if(message==""){
            		$.smallBox({
            			title : "提示" ,
            			content : "更新成功"  ,
            			timeout : 1000 ,
            		} , function(){
            			vm.editData = {};//清空表单数据
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
        
    }
})();
