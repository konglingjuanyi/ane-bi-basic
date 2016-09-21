(function() {
    'use strict';
    angular.module('app.anekpi').controller('AnekpiController', AnekpiController);    
	AnekpiController.$inject = ['$scope' ,"AnekpiService" , "routerHelper" , "Pagination","formValidator"];
    function AnekpiController($scope , AnekpiService , routerHelper , Pagination,formValidator) {
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
    	     $(".datepicker" ).datepicker({   
    	        dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],// 设置控件的星期名称显示  
    	        firstDay: 1, //设置排在第一列的是星期几，星期天为0，星期一为1，以此类推。  
    	        changeMonth: true,  //改变月份下拉框  
    	        changeYear: true,    //改变年份下拉框  
    	        monthNamesShort:['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],  
    	        dateFormat: 'yy-mm-dd' //设置日期格式  
    	    });  
        	//getAgingTypeAll("kpi_type"); 
        	//getForbiddenTypeAll("whether_forbidden"); 
        	refresh(vm.pageNum,vm.pageSize);
         };
        function refresh(pageNum,pageSize){
        	var kpiNm = vm.Query.kpiNm;
        	var kpiAbbr = vm.Query.kpiAbbr;
        	var status = vm.Query.status;
        	var queryParams = {
    				"kpiNm":kpiNm,
    				"kpiAbbr":kpiAbbr
  			};
        	 var jsonData = {
        				"search_condition":JSON.stringify(queryParams),
        				'pageNum' : pageNum,
        				'pageSize' :pageSize
      			};
        	 var promise = AnekpiService.queryDataByPage(jsonData);
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
        function getAgingTypeAll(type){
        	var promise2 = AnekpiService.getCodesByType(type);
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
        	var promise2 = AnekpiService.getCodesByType(type);
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
					var promise = AnekpiService.deleteData(jsonObj);
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
        	var promise = AnekpiService.deleteData(jsonObj);
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
        	var kpiNm = vm.Query.kpiNm;
        	var kpiAbbr = vm.Query.kpiAbbr;
        	var status = vm.Query.status;
        	var queryParams = {
    				"kpiNm":kpiNm,
    				"kpiAbbr":kpiAbbr
  			};
        	 var jsonData = {
        				"search_condition":JSON.stringify(queryParams),
        				'pageSize' :10,
        				'pageNum' : 1
      			};
        	  var promise = AnekpiService.queryDataByPage(jsonData);
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
					var promise = AnekpiService.updateData(jsonObj);
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
        	var kpiNm = vm.data.kpiNm;
        	var kpiAbbr = vm.data.kpiAbbr;
        	var kpiTypeCd = vm.data.kpiTypeCd;
        	var validBgnTime = vm.data.validBgnTime;
        	var validEndTime = vm.data.validEndTime;
        	if(kpiNm == "" || kpiNm == undefined){
        		$("#kpiNmText").css("border","1px red solid");
        		$.smallBox({
        			title : "提示" ,
        			content : "KPI名称是必填项!",
        			timeout : 1000 ,
        		} , function(){
        			return;
        		});
        		return;
        	};
        	if(kpiAbbr =="" || kpiAbbr==undefined){
        		$("#kpiAbbrText").css("border","1px red solid");
        		$.smallBox({
        			title : "提示" ,
        			content : "KPI简称是必填项!",
        			timeout : 1000 ,
        		} , function(){
        			return;
        		});
        		return;
        	}
        	var dataParams = {
    				"kpiNm":kpiNm,
    				"kpiAbbr":kpiAbbr,
    				"kpiTypeCdCd":kpiTypeCd,
    				"validBgnTime":validBgnTime,
    				"validEndTime":validEndTime
  			};
        	var successTip = "";
        	if(kpiNm!=""){
        		var promise = AnekpiService.addData(dataParams);//新增
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
            			content : "该KPI名称数据已经存在!"  ,
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
