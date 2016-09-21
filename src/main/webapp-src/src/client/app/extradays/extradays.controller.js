(function() {
    'use strict';

    angular.module('app.extradays').controller('ExtradaysController', ExtradaysController);

    ExtradaysController.$inject = ['$scope' ,"ExtradaysService" , "routerHelper" , "Pagination"];

    function ExtradaysController($scope , ExtradaysService , routerHelper , Pagination) {
        var vm = this;
        
        vm.extradays = [];//查询结果
        vm.extraday = {};//单条数据，详细信息
        
        vm.extradayQuery = {};//查询条件
        vm.extradayQuery.siteName = "";
        vm.extradayQuery.agingType = "";
        
        vm.typeTemp=[];//详细信息，时效类型
        vm.typeAll=[];//查询条件，时效类型
        vm.typeDistr=[];//分拨，时效类型
        vm.typeSite=[];//网点，时效类型
        
        vm.s="10";
        $(".is-edit").attr("disabled",true);
        vm.organizations = [];//网点或分拨查询结果
        vm.dialog = {};//名称弹窗查询条件
        var choosenSite = {
    		org_id:"",
    		org_name:"",
    		org_type_name:""
        };

        init();

        function init() {
        	refresh();
        	getAgingTypeAll("aging_type_all");
        	getAgingTypeDistr("aging_type_distr");
        	getAgingTypeSite("aging_type_site");
        }
        
        function refresh( p,s,siteName,agingType) {
    		var siteName = vm.extradayQuery.siteName;
    		var agingType = vm.extradayQuery.agingType;   
            var promise = ExtradaysService.getExtradays( p || 1,s || 10,siteName || "",agingType || "");
            promise.then(function(extradays) {
                vm.extradays = extradays;
            });
        }
        
        function getAgingTypeAll(type){
        	var promise2 = ExtradaysService.getCodesByType(type);
        	promise2.then(function(typeAll) {
                vm.typeAll = typeAll;
            });
        }
        function getAgingTypeDistr(type){
        	var promise3 = ExtradaysService.getCodesByType(type);
        	promise3.then(function(typeDistr) {
        		vm.typeDistr = typeDistr;
        	});
        }
        function getAgingTypeSite(type){
        	var promise4 = ExtradaysService.getCodesByType(type);
        	promise4.then(function(typeSite) {
        		vm.typeSite = typeSite;
        	});
        }
        
        vm.paginationHandler = function(){
            if( vm.extradays) {
                return Pagination.create( vm.extradays  , function(index){
                    refresh(index,vm.s);
                });
            }
        }
        vm.pageNumHandler = function(s){
        	refresh(1,s);
        }
        
        vm.queryExtraDay = function(){
        	vm.extraday = {};//清空表单数据
        	$(".is-edit").attr("disabled",true);
        	refresh();
        }
        
        vm.chooseRow = function(row){
        	$(".is-edit").attr("disabled",true);
        	if(row.type.indexOf("分拨")>=0){
        		vm.typeTemp = vm.typeDistr;
        	}else{
        		vm.typeTemp = vm.typeSite;
        	}
        	vm.extraday = row;
        }
        
        vm.changeAgingType = function(){
        	if(vm.extraday.type=="分拨"){
        		vm.typeTemp = vm.typeDistr;
        	}else{
        		vm.typeTemp = vm.typeSite;
        	}
        	vm.extraday.agingType = vm.typeTemp[0].codeName;
        }
        
        vm.deleteModal = function() {
        	if(vm.extraday.id!=0 && (vm.extraday.id=="" || !vm.extraday.id)){
        		$.smallBox({
        			title : "提示" ,
        			content : "请选择一条数据"  ,
        			timeout : 5000 ,
        		} , function(){});
        		return;
        	}
        	$('#delModal').modal();  
        }
        vm.deleteExtraDay = function(){
        	var promise = ExtradaysService.delExtradays(vm.extraday.id);
            promise.then(function() {
            	$.smallBox({
        			title : "提示" ,
        			content : "删除成功"  ,
        			timeout : 1000 ,
        		} , function(){
        			vm.extraday = {};//清空表单数据
        			refresh();
        		});
            });
        }
        
        vm.addExtraDay = function(){
        	vm.extraday = {};//清空表单数据
        	$(".is-edit").attr("disabled",false);
        	vm.extraday.type = "分拨";
        	vm.typeTemp = vm.typeDistr;
        	vm.extraday.agingType = vm.typeTemp[0].codeName;
        }
        
        vm.editExtraDay = function(){
        	if(vm.extraday.id!=0 && (vm.extraday.id=="" || !vm.extraday.id)){
        		$.smallBox({
        			title : "提示" ,
        			content : "请选择一条数据"  ,
        			timeout : 5000 ,
        		} , function(){});
        		return;
        	}
        	$(".is-edit").attr("disabled",false);
        }

        vm.saveExtraDay = function(){
        	if($("#siteName").attr("disabled")){//详细信息出于不可编辑状态
        		return;
        	}
        	var result = checkDetail();//检验输入项
        	if(result!=""){
        		$.smallBox({
                    title : "提示" ,
                    content : result  ,
                    timeout : 3000 ,
                } , function(){});
        		return;
        	}
        	if(vm.extraday.id!=0 && (vm.extraday.id=="" || !vm.extraday.id)){
        		add(vm.extraday);//新增
        	}else{
        		update(vm.extraday);//更新
        	}
        }
        
        function add(addData){
        	var promise = ExtradaysService.addExtradays(addData);
            promise.then(function(message) {
            	if(message==""){
            		$.smallBox({
            			title : "提示" ,
            			content : "新增成功"  ,
            			timeout : 1000 ,
            		} , function(){
            			vm.extraday = {};//清空表单数据
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
        /*
         * 更新
         */
        function update(updateData){
        	var promise2 = ExtradaysService.updateExtradays(updateData);
            promise2.then(function(message) {
            	if(message==""){
            		$.smallBox({
            			title : "提示" ,
            			content : "更新成功"  ,
            			timeout : 1000 ,
            		} , function(){
            			vm.extraday = {};// 清空表单数据
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
        /*
         * 编辑信息验证
         */
        function checkDetail(){
        	var result = "";
        	var reg = /^-?[1-9]\d*$/;
        	if(vm.extraday.siteName=="" || !vm.extraday.siteName){
        		result = result + "请选择名称";
        	}else if(vm.extraday.agingType=="" || !vm.extraday.agingType){
        		result = result + "请选择时效类型";
        	}else if(vm.extraday.extraDays=="" || !vm.extraday.extraDays){
        		result = result + "请输入额外天数";
        	}else if(!reg.test(vm.extraday.extraDays)){
        		result = result + "额外天数格式有误，请填写整数";
        	}
        	return result;
        }
        /*
         * 查询分拨/网点
         */
        vm.querySite = function(p,s){
        	var siteName = vm.dialog.org_name;
    		var queryType = vm.extraday.type;   
        	var promise = ExtradaysService.getOrgWithPage( p || 1,s || 10,siteName || "",queryType || "");
            promise.then(function(org) {
                vm.organizations = org;
            });
        }
        /*
         * 点击名称，弹出分拨选择模态框
         */
        vm.chooseName = function(type) {
        	$('#nameChooseModal').modal();
        	vm.querySite();
        }
        /*
         * 点击一行数据
         */
        vm.clickName = function(row,n){
        	choosenSite = row;
        	$('#siteTable tbody tr').eq(n).addClass('choosedRow').siblings().removeClass('choosedRow') ;//选中行变色
        }
        /*
         * 确认选择分拨
         */
        vm.confirmName = function(){
        	vm.extraday.siteId = choosenSite.org_id;
        	vm.extraday.siteName = choosenSite.org_name;
        	vm.extraday.siteProperty = choosenSite.org_type_name;
        	vm.dialog={};// 清空模态框
        }
        /*
         * 分拨选择模态框，换页
         */
        vm.orgPagehandler = function(){
            if( vm.organizations) {
                return Pagination.create( vm.organizations  , function(index){
                	vm.querySite(index,10);
                });
            }
        }
        
    }
})();
