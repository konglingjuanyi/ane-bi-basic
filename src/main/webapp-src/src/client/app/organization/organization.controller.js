(function() {
    'use strict';

    angular.module('app.organization').controller('OrganizationController', OrganizationController);

    OrganizationController.$inject = ['$scope' , "routerHelper", "OrganizationService" , "Pagination"];

    function OrganizationController($scope , routerHelper, OrganizationService, Pagination) {
        var vm = this;
//        vm.formValidator = formValidator;
        
        vm.queryData = {};//查询条件
        vm.editData = {};//详细信息
        vm.queryResult = [];//查询结果
        vm.originData = {};//原详细信息

        vm.areaEdit = [];
        vm.provinceAreaEdit = [];
        vm.dictEdit = [];
        vm.siteEdit = [];
        
        vm.s="10";
        $(".is-edit").attr("disabled",true);
        vm.editStatus = 0;//0不可编辑,1可编辑
        
        var oriSiteId="";
        var oriDictId="";
        var oriProvinceId="";
        var oriAreaId="";

        init();
        /*
         * 初始化
         */
        function init() {
        	refresh();
        	initArea();
        	initProvinceArea();
        	initDict();
        	initSite();
        }
        /*
         * 查询
         */
        function refresh( p,s ) {
        	var orgBrnchMtopRlQueryVO = vm.queryData ;
            var promise = OrganizationService.getOrganizations( p || 1,s || 10,orgBrnchMtopRlQueryVO);
            promise.then(function(pageData) {
                vm.queryResult = pageData;
    			vm.editData = {};//清空表单数据
    			$(".is-edit").attr("disabled",true);
    			vm.originData = {};
    			vm.editStatus = 0;
            });
        }
        /*
         * 区域
         */
        function initArea() {
            var promise = OrganizationService.getArea();
            promise.then(function(areaTemp) {
                vm.areaEdit = areaTemp;
            });
        }
        /*
         * 省区
         */
        function initProvinceArea() {
            var promise = OrganizationService.getProvinceArea();
            promise.then(function(provinceAreaTemp) {
            	vm.provinceAreaEdit = provinceAreaTemp;
            });
        }
        /*
         * 大区
         */
        function initDict() {
            var promise = OrganizationService.getDict();
            promise.then(function(dictTemp) {
            	vm.dictEdit = dictTemp;
            });
        }
        /*
         * 分拨
         */
        function initSite() {
            var promise = OrganizationService.getSite();
            promise.then(function(siteTemp) {
            	vm.siteEdit = siteTemp;
            });
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
         * 选中一行数据
         */
        vm.chooseRow = function(row){
        	$(".is-edit").attr("disabled",true);
        	vm.editStatus = 0;
        	vm.editData = row;
        	oriSiteId = row.siteId;
            oriDictId = row.dictId;
            oriProvinceId = row.provinceId;
            oriAreaId = row.areaId;
        }
        /*
         * 点击【查询】
         */
        vm.query = function(){
        	refresh();
        }
        /*
         * 点击【编辑】
         */
        vm.edit = function(){
        	var id = vm.editData.areaId;
        	if(id!=0 && (id=="" || !id)){
        		$.smallBox({
        			title : "提示" ,
        			content : "请先选择一条数据"  ,
        			timeout : 5000 ,
        		} , function(){});
        		return;
        	}
        	$(".is-edit").attr("disabled",false);
        	vm.editStatus = 1;
        }
        /*
         * 点击【保存】
         */
        vm.save = function(){
        	var id = vm.editData.areaId;
    		if(id!=0 && (id=="" || !id)){
	    		$.smallBox({
	    			title : "提示" ,
	    			content : "请先选择一条数据"  ,
	    			timeout : 5000 ,
	    		} , function(){});
	    		return;
    		}
    		if(vm.editStatus == 0){//详细信息出于不可编辑状态
    			$.smallBox({
	    			title : "提示" ,
	    			content : "请编辑后再保存"  ,
	    			timeout : 5000 ,
	    		} , function(){});
        		return;
        	}
    		var upAreaId = vm.editData.areaId;
    		var upProvinceId = vm.editData.provinceId;
    		var upDictId = vm.editData.dictId;
    		var upSiteId = vm.editData.siteId;
    		vm.originData={siteId:oriSiteId
	    				,dictId:oriDictId
	    				,provinceId:oriProvinceId
	    				,areaId:oriAreaId
	    				};
    		var promise = OrganizationService.saveOrg(upAreaId,upProvinceId,upDictId,upSiteId,vm.originData);
            promise.then(function(msg) {
            	if(msg==1){
            		$.smallBox({
            			title : "提示" ,
            			content : "修改成功"  ,
            			timeout : 1000 ,
            		} , function(){
            			refresh();
            		});
            	}else{
            		alertInfo("修改失败",3000);
            	}
            });
    	 }
        /*
         * 提示消息
         */
        function alertInfo(msg,time){
        	$.smallBox({
    			title : "提示",
    			content : msg,
    			timeout : time,
    		} , function(){});
        }
        
    }
})();
