# BI基础数据
##  项目说明
该项目前端使用node.js+angular.js技术，后台使用spring+ibatis。
##  git命令总结
查看当前分支跟踪的远程分支命令是：git branch -vv
git pull                         // 抓取远程仓库所有分支更新并合并到本地
git pull --no-ff                 // 抓取远程仓库所有分支更新并合并到本地，不要快进合并
git fetch origin                 // 抓取远程仓库更新
git merge origin/master          // 将远程主分支合并到本地当前分支
git co --track origin/branch     // 跟踪某个远程分支创建相应的本地分支
git co -b <local_branch> origin/<remote_branch>  // 基于远程分支创建本地分支，功能同上

git push                         // push所有分支
git push origin master           // 将本地主分支推到远程主分支
git push -u origin master        // 将本地主分支推到远程(如无远程主分支则创建，用于初始化远程仓库)
git push origin <local_branch>   // 创建远程分支， origin是远程仓库名
git push origin <local_branch>:<remote_branch>  // 创建远程分支
git push origin :<remote_branch>  //先删除本地分支(git br -d <branch>)，然后再push删除远程分支


##	如何开始
	
	maven 工程项目 ，有用到ane56的mavne私有库，http://101.231.237.70:88/content/groups/public/  

### 后端
	
	后端主要是 spring mvc + spring + mybatis ,里面有用到ane-db ，对数据库进行封装等.  

	restfull 形式提供数据 , 继承ResourceResponseSupport , 具体示例看UserExampleResource

	以spring javaconfig方式配置Spring 具体的在 com.ane56.customer.config 包里面

### 前端
	
	前段是以 nodejs ，gulp 来管理前端代码及编译打包

	准备环境  nodejs (4.4+) , gulp , bower. (bower 依赖git环境)

	进入 ane56-customer-web/src/main/webapp-src 目录下

	执行命令 npm install    		//原则上只要 nodejs安装后npm install 自动会将gulp 和bower安装. 如果gulp和bower没有安装请单独安装一下。

	gulp serve-dev  		//运行本地前端环境
	gulp deploy-webapp		//将本地前端代码发布到 ane56-customer-web webapp 目录下，以备web容器运行



#### 前端帮助说明
	目录结构

	webapp-src
		src
			client
				app/			所有自定义模块信息
				styles/			Less样式
				index.html 	    html页面
			server              用于前端测试开发模拟的后端数据


	webapp-src／app.module.json   配置模块信息如下:
	｀
		"index": {
	        "modules": ["core", "blocks", "smartadmin"],	//自定义模块信息
	        "dependencies": {								//bower里面的公共库依赖信息
	        	"jquery": "~2.1.0",
	          	"bootstrap": "~3.3.4",
	            "font-awesome": "4.3.0",
	            "angular": "1.4.4" ,
	            "jquery-ui": "1.10.3" 
	        }
	    } ,
	｀

	命令 
	gulp create-apps 					生成基础页面 ，依赖 app.module.json 里面配置
	gulp create-module --name=模块名  	生成模块模版


	如果很多不太清楚的先基于 user-example.html 先跑起来



	附：

	如果nodejs , bower 依赖下载太慢 还有maven 仓库链接不上 
	可以去 https://101.231.237.70:61000/svn/鲁班系统二期优化/docs/lib 
		里面有 ane-db-2.0.jar , 
		lib.zip
			bower_components  
			node_modules




