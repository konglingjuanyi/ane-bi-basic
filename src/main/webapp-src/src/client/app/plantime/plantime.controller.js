(function() {
    'use strict';
    angular.module('app.plantime').controller('PlantimeController', PlantimeController);    
	PlantimeController.$inject = ['$scope' ,"PlantimeService" , "routerHelper" , "Pagination","formValidator"];
    function PlantimeController($scope , PlantimeService , routerHelper , Pagination,formValidator) {
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
        	refresh(vm.pageNum,vm.pageSize);
         };
        function refresh(pageNum,pageSize){
        	var siteId = vm.Query.siteId;
        	var queryParams = {
    				"siteId":siteId    			
  			};
        	 var jsonData = {
        				"search_condition":JSON.stringify(queryParams),
        				'pageNum' : pageNum,
        				'pageSize' :pageSize
      			};
        	 var promise = PlantimeService.queryDataByPage(jsonData);
	          promise.then(function(results) {
	              vm.result = JSON.parse(results);
	              var current =  vm.result.current;
	              var limit = vm.result.pageSize;
	              var total = vm.result.total;
	              var offset = vm.result.offset;
	              var object = {
	      				"current":current,
	      				"limit":limit,
	      				"total":total,
	      				"offset":offset
	    			};
	              vm.codes = object;
	          });
        };
        function getAgingTypeAll(type){
        	var promise2 = PlantimeService.getCodesByType(type);
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
					var promise = PlantimeService.deleteData(jsonObj);
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
        	var promise = PlantimeService.deleteData(jsonObj);
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
        	var siteId = vm.Query.siteId;
        	var queryParams = {
    				"siteId":siteId
  			};
        	 var jsonData = {
        				"search_condition":JSON.stringify(queryParams),
        				'pageSize' :10,
        				'pageNum' : 1
      			};
        	  var promise = PlantimeService.queryDataByPage(jsonData);
              promise.then(function(results) {
                  vm.result = JSON.parse(results);
                  var length = vm.result.beanList.length;
                  if(length<=0){
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
					var promise = PlantimeService.updateData(jsonObj);
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
        	var siteId = vm.data.siteId;
        	var veTypeCd = vm.data.veTypeCd;
        	var shmtOpCtime = vm.data.shmtOpCtime;
        	var unldOpCtime = vm.data.unldOpCtime;
        	if(siteId == "" || siteId == undefined){
        		$("#siteIdText").css("border","1px red solid");
        		$.smallBox({
        			title : "提示" ,
        			content : "分拨是必填项!",
        			timeout : 1000 ,
        		} , function(){
        			return;
        		});
        		return;
        	};
        	if(veTypeCd =="" || veTypeCd==undefined){
        		$("#veTypeCdText").css("border","1px red solid");
        		$.smallBox({
        			title : "提示" ,
        			content : "车型是必填项!",
        			timeout : 1000 ,
        		} , function(){
        			return;
        		});
        		return;
        	}
        	var dataParams = {
    				"siteId":siteId,
    				"veTypeCd":veTypeCd,
    				"shmtOpCtime":shmtOpCtime,
    				"unldOpCtime":unldOpCtime
  			};
        	var successTip = "";
        	if(siteId != ""){
        		var promise = PlantimeService.addData(dataParams);//新增
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
            			content : "该分拨中心数据已经存在!"  ,
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
