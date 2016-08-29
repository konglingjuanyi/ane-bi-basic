(function() {
    'use strict';

    angular.module('app.radioStandard').controller('RadioStandardController', RadioStandardController);

    RadioStandardController.$inject = ['$scope' ,  "formValidator" , "routerHelper", "RadioStandardService"];

    function RadioStandardController($scope , formValidator , routerHelper, RadioStandardService) {
        var vm = this;
        vm.formValidator = formValidator;
        vm.radioStandards=[];
        vm.radioStandard={};
        init();

        function init() {
        	refresh();
        }
        
        function refresh(){
        	var promise = RadioStandardService.getRadio();
            promise.then(function(radioStandards) {
                console.log(radioStandards);
                vm.radioStandards = radioStandards;
                if(vm.radioStandards.length!=0){
                	vm.radioStandard = vm.radioStandards[0];
                	var radioTemp = vm.radioStandards[0].radio*100;
                	vm.radioStandard.radio = radioTemp.toFixed(2);
                }
            });
        }
        
        vm.edit = function(){
        	$("#radio").attr("disabled",false);
        }
        
        vm.save = function(){
        	if($("#radio").attr("disabled")){
        		return;
        	}
        	//验证是否填写承接网点比例标准
        	if(!vm.radioStandard.radio){
        		$.smallBox({
                    title : "提示" ,
                    content : "请校验承接网点比例标准"  ,
                    timeout : 5000 ,
                } , function(){});
        		return;
        	}else{//验证格式
        		var reg = /^(\d{1,2}(\.\d{1,2})?|100|100.0|100.00)$/;
        		if(!reg.test(vm.radioStandard.radio)){
            		$.smallBox({
                        title : "提示" ,
                        content : "承接网点比例标准格式有误"  ,
                        timeout : 5000 ,
                    } , function(){});
            		return;
            	}
        	}
        	var radio = vm.radioStandard.radio/100;
        	if(vm.radioStandard.id){
        		var promise = RadioStandardService.updateRadio(radio);
        	}else{
        		var promise = RadioStandardService.createRadio(radio);
        	}
        	promise.then(function() {
                $.smallBox({
                    title : "提示" ,
                    content : "操作成功"  ,
                    timeout : 1000 ,
                } , function(){
                	$("#radio").attr("disabled",true);
                	refresh();
                });
            });
        }
        
    }
})();
