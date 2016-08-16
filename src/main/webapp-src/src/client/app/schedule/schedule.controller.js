(function() {
    'use strict';

    angular.module('app.schedule').controller('ScheduleController', ScheduleController);
    
    ScheduleController.$inject = ['$scope' ,  "formValidator" ,'routerHelper' ,'ScheduleService', "Pagination",'$sce'];

    function ScheduleController($scope , formValidator,routerHelper,ScheduleService,Pagination,$sce) {
        var vm = this;
        vm.formValidator = formValidator;
        vm.s="10";
        vm.exportType="1";
        vm.stopsNum = 0;
        
        vm.schedules = [];
        vm.schedule = {};

        init();

        function init() {
        	refresh();
        }
        
        function refresh(p,s){
        	var promise = ScheduleService.getPlanschedulesWithPage( p || 1,s || 10,vm.schedule);
            promise.then(function(schedules) {
                console.log(schedules);
                for(var i=0;i<schedules.result.length;i++){
                	if(vm.stopsNum<schedules.result[i].stopsNum){
                		vm.stopsNum = schedules.result[i].stopsNum;
                	}
                }
                //设置表格宽度
                $('#tbMain').width(1500+vm.stopsNum*500);
                //拼接表头
                var tbHead = "";
                tbHead = tbHead + "<th>班线</th><th>装卸类型</th><th>车型</th><th>发车周期</th><th>始发地</th><th>始发时间</th>";
                for(var j=1;j<=vm.stopsNum;j++){
                	tbHead = tbHead + "<th>经停地"+j+"</th>";
                	tbHead = tbHead + "<th>干线时效</th><th>规定到达时间</th><th>中转间隔时间</th><th>规定离开时间</th>";
                }
                tbHead = tbHead + "<th>到达地</th><th>干线时效</th><th>到达时间</th><th>货物线路</th> -->";
                $('#tbHead').html(tbHead);
                //拼接数据
                var tbBody = "";
                for(var k=0;k<schedules.result.length;k++){
                	tbBody = tbBody + '<tr>';
                	tbBody = tbBody + '<td>' + schedules.result[k].routeName + '</td>';
                	tbBody = tbBody + '<td>' + schedules.result[k].loadType + '</td>';
                	tbBody = tbBody + '<td>' + schedules.result[k].vehicleType + '</td>';
                	tbBody = tbBody + '<td>' + schedules.result[k].departPeriod + '</td>';
                	tbBody = tbBody + '<td>' + schedules.result[k].departPlace + '</td>';
                	tbBody = tbBody + '<td>' + schedules.result[k].departTimeStr + '</td>';
                	for(var m=0;m<vm.stopsNum;m++){
                		if(m<schedules.result[k].stopsNum && m<schedules.result[k].stopsVO.length){
	                		tbBody = tbBody + '<td>' + schedules.result[k].stopsVO[m].stopName + '</td>';
	                		tbBody = tbBody + '<td>' + schedules.result[k].stopsVO[m].arteryTimeStr + '</td>';
	                		tbBody = tbBody + '<td>' + schedules.result[k].stopsVO[m].arriveTimeStr + '</td>';
	                		tbBody = tbBody + '<td>' + schedules.result[k].stopsVO[m].intervalTimeStr + '</td>';
	                		tbBody = tbBody + '<td>' + schedules.result[k].stopsVO[m].leaveTimeStr + '</td>';
                		}else{
                			tbBody = tbBody + '<td>' + " " + '</td>';
	                		tbBody = tbBody + '<td>' + " " + '</td>';
	                		tbBody = tbBody + '<td>' + " " + '</td>';
	                		tbBody = tbBody + '<td>' + " " + '</td>';
	                		tbBody = tbBody + '<td>' + " " + '</td>';
                		}
                	}
                	tbBody = tbBody + '<td>' + schedules.result[k].destination + '</td>';
                	tbBody = tbBody + '<td>' + schedules.result[k].arteryTimeStr + '</td>';
                	tbBody = tbBody + '<td>' + schedules.result[k].arriveTimeStr + '</td>';
                	tbBody = tbBody + '<td>' + schedules.result[k].cargoRoute + '</td>';
                	tbBody = tbBody + '</tr>';
                }
                $('#tbBody').html(tbBody);
//                vm.schedules = schedules;
            });
        }
        
        vm.paginationHandler = function(){
            if( vm.schedules) {
                return Pagination.create( vm.schedules  , function(index){
                    // console.log(index);
                    refresh(index);
                });
            }
        }
        
        vm.pageNumHandler = function(s){
        	refresh(1,s);
        }
        
        vm.query = function(){
        	refresh();
        }
        
        vm.exportModal = function(){
        	$('#exportModal').modal();  
        }
        vm.exportDate = function(type){
        	if(type=="1"){//导出查询结果
        		
        	}else if(type=="2"){//导出全国计划班次表
        		
        	}
        }
        
    }
})();
