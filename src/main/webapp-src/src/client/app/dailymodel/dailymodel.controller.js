(function() {
    'use strict';
    angular.module('app.dailymodel').controller('DailymodelController', DailymodelController);    
	DailymodelController.$inject = ['$scope' ,"DailymodelService" , "routerHelper" , "Pagination","formValidator"];
    function DailymodelController($scope , DailymodelService , routerHelper , Pagination,formValidator) {
    	var wheaterDel = false;
        var vm = this;
        vm.formValidator = formValidator;
        vm.codes = {};
        vm.Query = {};
        vm.result = {};
        vm.data = {};    
        vm.pageNum="1";   
        vm.pageSize="10";       
        init();
        function init(){
        	//getAgingTypeAll("kpi_type"); 
        	//getForbiddenTypeAll("whether_forbidden"); 
        	getParentModle();
        	refresh(vm.pageNum,vm.pageSize);
         };
        function refresh(pageNum,pageSize){
        	var mdlNm = vm.Query.mdlNm;
        	var showSeqno = vm.Query.showSeqno;
        	var queryParams = {
    				"mdlNm":mdlNm,
    				"showSeqno":showSeqno
  			};
        	 var jsonData = {
        				"search_condition":JSON.stringify(queryParams),
        				'pageNum' : pageNum,
        				'pageSize' :pageSize
      			};
        	 var promise = DailymodelService.queryDataByPage(jsonData);
	          promise.then(function(results) {
	              vm.result = results.result;
	              var current = results.current;
	              var limit = results.limit;
	              var total = results.total;
	              var offset = results.offset;
	              var object = {
	      				"current":current,
	      				"limit":limit,
	      				"total":total,
	      				"offset":offset
	    			};
	              vm.codes = object;
	          });
        };
        function getParentModle(){
        	var promise2 = DailymodelService.getParentModle();
        	promise2.then(function(result) {
        		var select = new Array();
        		for(var i=0;i<result.length;i++){
        			var value = result[i].mdlId;
        			var name = result[i].mdlNm;
        			var option = {"label":name,"value":value};
        			select.push(option);
        		}
                vm.parentModel = select;
            });
        };
        function getAgingTypeAll(type){
        	var promise2 = DailymodelService.getCodesByType(type);
        	promise2.then(function(typeAll) {
        		var select = new Array();
        		for(var i=0;i<typeAll.length;i++){
        			var value = typeAll[i].codeValue;
        			var name = typeAll[i].codeName;
        			var option = {"label":name,"value":value};
        			select.push(option);
        		}
                vm.typeAll = select;
            });
        };
        function getForbiddenTypeAll(type){
        	var promise2 = DailymodelService.getCodesByType(type);
        	promise2.then(function(typeAll) {
        		var select = new Array();
        		for(var i=0;i<typeAll.length;i++){
        			var value = typeAll[i].codeValue;
        			var name = typeAll[i].codeName;
        			var option = {"label":name,"value":value};
        			select.push(option);
        		}
                vm.status = select;
            });
        };
        vm.paginationHandler = function(){
        	  if(vm.codes) {
                  return Pagination.create(vm.codes,function(index){
                      refresh(index,vm.pageSize);
                  });
              };
        };
        vm.pageNumHandler = function(pageSize){
        	refresh(1,pageSize);
        };  
        /*vm.chooseRow = function(row){
        	vm.data = row;
        };*/
        vm.deleteData = function(data){
        	vm.data = data;
        	var jsonStr = JSON.stringify(vm.data);
        	var jsonObj = JSON.parse(jsonStr);
        	//$('#delModal').modal();  
        	$.SmartMessageBox({
				title : "<i class='fa fa-warn' style='color:green'></i>提示",
				content : "你确认要删除该数据?",
				buttons : '[确认][取消]'
			}, function(ButtonPressed) {
				if (ButtonPressed == "确认") {
					var promise = DailymodelService.deleteData(jsonObj);
					promise.then(function(result) {
		            	if(result==1){
		            		$.smallBox({
		            			title : "提示" ,
		            			content : "删除成功!"  ,
		            			timeout : 1000 ,
		            		} , function(){
		            			refresh(vm.pageNum,vm.pageSize);
		            		});
		            	}else{
		            		$.smallBox({
		            			title : "提示" ,
		            			content : "删除失败!"  ,
		            			timeout : 1000 ,
		            		} , function(){
		            			return;
		            		});
		            	};
		            });
				}
			});
        };
        vm.confirmDeleteData = function(){
        	var jsonStr = JSON.stringify(vm.data);
        	var jsonObj = JSON.parse(jsonStr);
        	var promise = DailymodelService.deleteData(jsonObj);
            promise.then(function(result) {
            	if(result==1){
            		$.smallBox({
            			title : "提示" ,
            			content : "删除成功"  ,
            			timeout : 1000 ,
            		} , function(){
            			refresh(vm.pageNum,vm.pageSize);
            		});
            	}else{
            		$.smallBox({
            			title : "提示" ,
            			content : "删除失败"  ,
            			timeout : 1000 ,
            		} , function(){
            			return false;
            			//refresh(vm.pageNum,vm.pageSize);
            		});
            	};
            });
        };
        vm.queryDataByPage = function(){
        	var showSeqno = vm.Query.showSeqno;
        	var mdlNm = vm.Query.mdlNm;
        	var queryParams = {
    				"mdlNm":mdlNm,
    				"showSeqno":showSeqno
  			};
        	 var jsonData = {
        				"search_condition":JSON.stringify(queryParams),
        				'pageSize' :10,
        				'pageNum' : 1
      			};
        	  var promise = DailymodelService.queryDataByPage(jsonData);
              promise.then(function(results) {
            	  vm.result = results.result;
	              var current = results.current;
	              var limit = results.limit;
	              var total = results.total;
	              var offset = results.offset;
	              var object = {
	      				"current":current,
	      				"limit":limit,
	      				"total":total,
	      				"offset":offset
	    			};
	              vm.codes = object;
                  if(total<=0){
                	  $("#warn").show();
                  }else{
                	  $("#warn").hide();
                  }
              });
        };
        vm.updateData = function(data){
        	vm.data = data;
        };
        vm.saveData = function (){
        	var data = vm.data;
        	var jsonStr = JSON.stringify(data);
        	if("{}"==jsonStr){
        		$.smallBox({
        			title : "提示" ,
        			content : "请选择要修改的数据!"  ,
        			timeout : 1000 ,
        		} , function(){
        		});
        		return;
        	}
        	var jsonObj = JSON.parse(jsonStr);
        	$.SmartMessageBox({
				title : "<i class='fa fa-warn' style='color:green'></i>提示",
				content : "你确认要修改该数据?",
				buttons : '[确认][取消]'
			}, function(ButtonPressed) {
				if (ButtonPressed == "确认") {
					var promise = DailymodelService.updateData(jsonObj);
					promise.then(function(result) {
		            	if(result==1){
		            		$.smallBox({
		            			title : "提示" ,
		            			content : "修改成功!"  ,
		            			timeout : 1000 ,
		            		} , function(){
		            			refresh(vm.pageNum,vm.pageSize);
		            		});
		            	}else{
		            		$.smallBox({
		            			title : "提示" ,
		            			content : "修改失败!"  ,
		            			timeout : 1000 ,
		            		} , function(){
		            			refresh(vm.pageNum,vm.pageSize);
		            		});
		            	};
		            });
				}
			});
        	
        	
        };
        vm.addData = function(){
        	var mdlNm = vm.data.mdlNm;
        	var suprMdlId = vm.data.suprMdlId;
        	var showSeqno = vm.data.showSeqno;
        	var validFlag = vm.data.validFlag;
        	if(mdlNm == "" || mdlNm == undefined){
        		$("#mdlNmText").css("border","1px red solid");
        		$.smallBox({
        			title : "提示" ,
        			content : "模块名称是必填项!",
        			timeout : 1000 ,
        		} , function(){
        			return;
        		});
        		return;
        	};
        	var dataParams = {
    				"mdlNm":mdlNm,
    				"suprMdlId":suprMdlId,
    				"showSeqno":showSeqno,
    				"validFlag":validFlag
  			};
        	var successTip = "";
        	if(mdlNm!=""){
        		var promise = DailymodelService.addData(dataParams);//新增
        		promise.then(function(result) {
            	if(result==1){
            		$.smallBox({
            			title : "提示" ,
            			content : "保存成功!"  ,
            			timeout : 1000,
            		} , function(){
            			refresh(vm.pageNum,vm.pageSize);
            		});
            	}if(result==-1){
            		$.smallBox({
            			title : "提示" ,
            			content : "该模块数据已经存在!"  ,
            			timeout : 1000 ,
            		} , function(){	           			
                       return;
            		});
            	}else{
            		$.smallBox({
            			title : "提示" ,
            			content : "保存失败!"  ,
            			timeout : 1000 ,
            		} , function(){	           			
                       return;
            		});
            	};
	            });       		
   
        	}
        };        
    }
})();
