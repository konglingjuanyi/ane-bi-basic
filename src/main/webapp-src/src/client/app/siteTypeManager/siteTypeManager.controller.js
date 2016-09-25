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
        /*
         * 初始化
         */
        function init() {
        	refresh();
        }
        /*
         * 刷新数据
         */
        function refresh(p,s){
        	var siteName = vm.queryData.siteName;
        	var statFlag = vm.queryData.statFlag;
            var promise = SiteTypeManagerService.getDataWithPage( p || 1,s || 10,siteName || "",statFlag || "");
            promise.then(function(pageData) {
            	vm.queryResult = pageData;
            	vm.editData = {};//清空表单数据
            	$(".is-edit").attr("disabled",true);
            });
        }
        /*
         * 选择一行数据
         */
        vm.chooseRow = function(row){
        	$(".is-edit").attr("disabled",true);
        	vm.editData = row;
        }
        /*
         * 分页处理
         */
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
        /*
         * 点击查询
         */
        vm.query = function(){
        	refresh();
        }
        /*
         * 点击编辑
         */
        vm.edit = function(){
        	var id = vm.editData.orgBrnchId;
        	if(id!=0 && (id=="" || !id)){
        		var message="请先选择一条数据";
        		alertInfo(message,3000);
        		return;
        	}
        	$(".is-edit").attr("disabled",false);
        }
        /*
         * 点击保存
         */
        vm.save = function(){
        	var id = vm.editData.orgBrnchId;
        	if(id!=0 && (id=="" || !id)){
        		var message="请选择一条数据，编辑后保存";
        		alertInfo(message,3000);
        		return;
        	}
        	var promise = SiteTypeManagerService.updateOrgBrnchClfc(vm.editData);
            promise.then(function(message) {
            	if(message==1){
            		$.smallBox({
            			title : "提示" ,
            			content : "更新成功"  ,
            			timeout : 1000 ,
            		} , function(){
            			refresh();
            		});
            	}else{
            		var msg = "更新失败";
            		alertInfo(msg,3000);
            	}
            });
        }
        /*
         * 提示
         */
        function alertInfo(msg,time){
        	$.smallBox({
    			title : "提示" ,
    			content : msg  ,
    			timeout : time ,
    		} , function(){});
        }
        
    }
})();
