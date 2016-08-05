(function() {
    'use strict';

    /**
     * 本Constants文件的内容有gulp constants命令基于--env的值自动生成(默认值为dev)，！！！请不要手动修改！！！；
     * --env=dev 生产环境（默认值）
     * --env=stage 预生成环境
     * --env=prod 生产环境
     *
     *  gulp reset-constaints  将用户文件内容恢复到默认本地配置状态
     */
    angular.module("app.core")
    
    .constant("SERVER_API_URL", "/ane-dispatch-platform/")
    
    ;

})();