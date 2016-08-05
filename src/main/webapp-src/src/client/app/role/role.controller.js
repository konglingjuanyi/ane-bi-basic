(function() {
	'use strict';

	angular.module('app.role').controller('RoleController',
			RoleController);

	RoleController.$inject = [ '$scope', '$stateParams', 'routerHelper',
			"RoleService", "formValidator" ];

	function RoleController($scope, $stateParams, routerHelper,
			RoleService, formValidator) {
		var vm = this;
		vm.formValidator = formValidator;
		vm.role = {};
		vm.role.type="0";		
		vm.resource = {};

		init();

		function init() {
			queryResource();
			if ($stateParams.roleId) {
				var promise = RoleService.getRole($stateParams.roleId);
				promise.then(function(role) {
					vm.role = role;
					vm.role.type = vm.role.type + "";
				});
			}
			

		}

		vm.saveOrUpdate = function() {			
			var resourceIds = [];
			 $('input[type=checkbox]:not(.ng-hide):checked').each(function(i){
				 resourceIds.push($(this).attr("id"));
		     });
			 
			if (vm.role.id) {
				var promise2 = RoleService.update(vm.role);
			} else {
				var promise2 = RoleService.add(vm.role);
			}					
			promise2.then(function(data) {
				
				if (!vm.role.id){
					vm.role.id = data;
				var promise = RoleService.saveRoleResource(vm.role.id,resourceIds);

				}else{
					var promise = RoleService.saveRoleResource(vm.role.id,resourceIds);
				}
				$.smallBox({
					title : "提示",
					content : "操作成功.",
					timeout : 1000,
				}, function() {
					routerHelper.go("list");
//					routerHelper.go("list", { roleId: vm.role.id });

				});
			},function() {
                $.smallBox({
                    title : "提示" ,
                    content : "操作失败."  ,
                    timeout : 3000 ,
                } , function(){});
            });

		}
		vm.returnList = function() {
			routerHelper.go("list");
		}

	     //查询所有的菜单
		  function queryResource(){
			  /*vm.source = [{id:"1",name:"系统设置",checked:false},
			               {id:"2",name:"权限设置",checked:false}];*/
			  if ($stateParams.roleId) {
				  var promise = RoleService.getResource($stateParams.roleId);
		            promise.then(function(resource) {
		                vm.resource = resource;
		            });
				}else{
					  var promise = RoleService.getResource($stateParams.roleId);
		            promise.then(function(resource) {
		                vm.resource = resource;
		            });
				}		  	        	
	        }

	}
})();
