(function() {
    'use strict';

    angular.module('app.provDictrt').controller('ProvDictrtController', ProvDictrtController);

    ProvDictrtController.$inject = ['$scope' , "routerHelper", "ProvDictrtService" , "Pagination"];

    function ProvDictrtController($scope , routerHelper, ProvDictrtService , Pagination) {
        var vm = this;
//      vm.formValidator = formValidator;

      vm.queryData = {};// 查询条件
      vm.editData = {};// 详细信息
      vm.queryResult = [];// 查询结果
      var editArea = [];
      var editProvinceArea = [];
      vm.editParentData = [];
      
      var editStatus=0;//是否可以点击编辑或删除：0不可，1可以
      var saveStatus=0;//数据状态：0无，1新增，2编辑
      vm.queryData.orgBrnchLvlCd="22";// 默认层级：省区
      vm.s="10";
      $(".is-edit").attr("disabled",true);
      init();
      /*
       * 初始化
       */
      function init() {
      	refresh();// 查询数据
      	initProvinceArea();// 获取省区
      	initArea();// 获取区域
      }
      /*
       * 查询省区/大区
       */
      function refresh(p,s){
      	var lvl = vm.queryData.orgBrnchLvlCd;
      	var name = vm.queryData.orgBrnchNm;
      	var promise = ProvDictrtService.getWithPage( p || 1,s || 10,lvl || "22",name || "");
          promise.then(function(pageData) {
              vm.queryResult = pageData;
              vm.editData = {};// 清空表单数据
              $(".is-edit").attr("disabled",true);//编辑区禁用
              editStatus = 0;
              saveStatus = 0;
          });
      }
      /*
       * 获取所有省区
       */
      function initArea(){
      	var promise = ProvDictrtService.getAreaAll();
      	promise.then(function(dict) {
      		editArea = dict;
      		vm.editParentData = editArea;
      	});
      }
      /*
       * 获取所有大区
       */
      function initProvinceArea(){
      	var promise = ProvDictrtService.getProvinceAll();
          promise.then(function(province) {
              editProvinceArea = province;
          });
      }
      /*
       * 页数跳转
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
      	vm.editData = row;
      	$(".is-edit").attr("disabled",true);
      	editStatus = 1;//可点击编辑或删除
      }
      /*
       * 查询按钮
       */
      vm.query = function(){
      	refresh();
      }
      /*
       * 新增
       */
      vm.add = function(){
      	$(".is-edit").attr("disabled",false);
      	vm.editData = {};// 清空表单数据
      	vm.editData.orgBrnchLvlCd = "22";
      	vm.editData.suprOrgBrnchId = vm.editParentData[0].orgBrnchId;
      	editStatus=0;//不可点击编辑/删除
      	saveStatus = 1;//新增状态
      }
      /*
       * 编辑
       */
      vm.edit = function(){
      	if(editStatus==0){
      		alertInfo("请先选择一条数据",3000);
      		return;
      	}
      	$(".is-edit").attr("disabled",false);
      	$("#lvlEdit").attr("disabled",true);
      	saveStatus = 2;//编辑状态
      }
      /*
       * 保存
       */
      vm.save = function(){
      	if(saveStatus==0){
      		alertInfo("请先选择一条数据",3000);
      		return;
      	}
      	var result = checkRequired();
      	if(result!=""){
      		alertInfo(result,3000);
      		return;
      	}
      	if(saveStatus==1){// 新增
      		var promise = ProvDictrtService.add(vm.editData);
      	}else if(saveStatus==2){// 修改
      		var promise = ProvDictrtService.update(vm.editData);
      	}
      	promise.then(function(msg) {
      		if(msg==1){
      			$.smallBox({
          			title : "提示" ,
          			content : "操作成功"  ,
          			timeout : 1000 ,
          		} , function(){
          			refresh();
          		});
      		}else{
      			alertInfo("操作失败",3000);
      		}
      	});
      }
      /*
       * 删除
       */
      vm.deleteModal = function() {
      	if(editStatus==0){
      		alertInfo("请先选择一条数据",3000);
      		return;
      	}
      	$('#delModal').modal();  
      }
      vm.deleteData = function(){
      	var promise = ProvDictrtService.changeStatus(vm.editData);
          promise.then(function() {
          	$.smallBox({
      			title : "提示" ,
      			content : "删除成功"  ,
      			timeout : 1000 ,
      		} , function(){
      			refresh();
      		});
          });
      }
      /*
       * 变更层级
       */
      function changeParent(type){
      	if(type=="22"){
      		vm.editParentData = editArea;
      	}else if(type=="23"){
      		vm.editParentData = editProvinceArea;
      	}
      	if(vm.editParentData.length>0){
      		vm.editData.suprOrgBrnchId = vm.editParentData[0].orgBrnchId;
      	}
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
      /*
       * 校验必填项
       */
      function checkRequired(){
      	var result = "";
      	var reg = /^(0|[1-9]\d{0,7})$/;
      	if(vm.editData.orgBrnchLvlCd=="" || !vm.editData.orgBrnchLvlCd){
      		result = result + "请选择层级";
      	}else if(vm.editData.orgBrnchId=="" || !vm.editData.orgBrnchId){
      		result = result + "请输入ID";
      	}else if(vm.editData.orgBrnchNm=="" || !vm.editData.orgBrnchNm){
      		result = result + "请输入名称";
      	}else if(!reg.test(vm.editData.orgBrnchId)){
      		result = result + "ID格式有误，请填写8位以内整数";
      	}
      	return result;
      }
      
  }
})();
