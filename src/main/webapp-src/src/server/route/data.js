module.exports = {
	getUsers : getUsers,
	getUsers2 : getUsers2,
	getUser : getUser,
	getPlanschedulesWithPage : getPlanschedulesWithPage,
};

function getUser() {
	return {
		"status" : "SUCCESS",
		"result" : {
			"id" : 235957252521984,
			"username" : "abc",
			"password" : "123456",
			"nikename" : "abc1234567",
			"created" : 1468252800000,
			"status" : true
		}
	};
}

function getUsers() {
	return {
		"status" : "SUCCESS",
		"result" : [ {
			"id" : 235957252521984,
			"username" : "abc",
			"password" : "123456",
			"nikename" : "abc1234567",
			"created" : 1468252800000,
			"status" : true
		}, {
			"id" : 235969623097344,
			"username" : "abc",
			"password" : "123456",
			"nikename" : "abc1234567",
			"created" : 1468252800000,
			"status" : true
		}, {
			"id" : 235974638567424,
			"username" : "abc",
			"password" : "123456",
			"nikename" : "abc1234567",
			"created" : 1468252800000,
			"status" : true
		}, {
			"id" : 235979888394240,
			"username" : "abc",
			"password" : "123456",
			"nikename" : "abc1234567",
			"created" : 1468252800000,
			"status" : true
		}, {
			"id" : 236086589259776,
			"username" : "abc",
			"password" : "123456",
			"nikename" : "abc1234567",
			"created" : 1468252800000,
			"status" : true
		}, {
			"id" : 236111474262016,
			"username" : "abc",
			"password" : "123456",
			"nikename" : "abc1234567",
			"created" : 1468252800000,
			"status" : true
		} ]
	};
}

function getUsers2() {
	return {
		"status" : "SUCCESS",
		"result" : {
			"result" : [ {
				"id" : 235974638567424,
				"username" : "abc",
				"password" : "123456",
				"nikename" : "abc1234567",
				"created" : 1468252800000,
				"status" : true
			}, {
				"id" : 2335979888394240,
				"username" : "abc",
				"password" : "123456",
				"nikename" : "abc1234567",
				"created" : 1468252800000,
				"status" : true
			} ,
			{
				"id" : 235979888394240,
				"username" : "abc",
				"password" : "123456",
				"nikename" : "abc1234567",
				"created" : 1468252800000,
				"status" : true
			},
			{
				"id" : 235979888394240,
				"username" : "abc",
				"password" : "123456",
				"nikename" : "abc1234567",
				"created" : 1468252800000,
				"status" : true
			}],
			"total" : 7,
			"offset" : 2,
			"limit" : 2,
			"current" : 2
		}
	};	
}

function getPlanschedulesWithPage(){
	return {
		"status":"SUCCESS",
		"result":{
			"result":[{
				"id":235974638567424,
				"routeName":"江门-中山-江门",
				"loadType":"直发",
				"vehicleType":"9.6",
				"departPeriod":"周一、周三、周四、周五、周六、周日",
				"departPlace":"江门分拨中心",
				"departTime":"0:10",
				"departTimeStr":"0:10",
				"stopsVO":[{
					"stopName":"停001",
					"arteryTime":"1:11",
					"arriveTime":"2:11",
					"intervalTime":"3:11",
					"leaveTime":"4:11",
					"arteryTimeStr":"1:11",
					"arriveTimeStr":"2:11",
					"intervalTimeStr":"3:11",
					"leaveTimeStr":"4:11"
				},{
					"stopName":"停001",
					"arteryTime":"1:12",
					"arriveTime":"2:12",
					"intervalTime":"3:12",
					"leaveTime":"4:12",
					"arteryTimeStr":"1:12",
					"arriveTimeStr":"2:12",
					"intervalTimeStr":"3:12",
					"leaveTimeStr":"4:12"
				}],
				"destination":"江门分拨中心",
				"arteryTime":"1:30",
				"arteryTimeStr":"1:30",
				"arriveTime":"8:50",
				"arriveTimeStr":"8:50",
				"cargoRoute":"江门-中山<br>中山-江门",
				"stopNames":"",
				"stopsNum":"2"
			},{
				"id":235974638567424,
				"routeName":"abc",
				"loadType":"两地装卸",
				"vehicleType":"17.6m",
				"departPeriod":"周三",
				"departPlace":"广州2",
				"departTime":"0:11",
				"departTimeStr":"0:11",
				"stopsVO":[{
					"stopName":"停011",
					"arteryTime":"1:12",
					"arriveTime":"2:12",
					"intervalTime":"3:12",
					"leaveTime":"4:12",
					"arteryTimeStr":"1:12",
					"arriveTimeStr":"2:12",
					"intervalTimeStr":"3:12",
					"leaveTimeStr":"4:12"
				},{
					"stopName":"停012",
					"arteryTime":"1:40",
					"arriveTime":"1:40",
					"intervalTime":"6:00",
					"leaveTime":"7:30",
					"arteryTimeStr":"1:40",
					"arriveTimeStr":"1:40",
					"intervalTimeStr":"6:00",
					"leaveTimeStr":"7:30"
				},{
					"stopName":"停013",
					"arteryTime":"3:40",
					"arriveTime":"4:40",
					"intervalTime":"8:00",
					"leaveTime":"9:30",
					"arteryTimeStr":"3:40",
					"arriveTimeStr":"4:40",
					"intervalTimeStr":"8:00",
					"leaveTimeStr":"9:30"
				}],
				"destination":"c",
				"arteryTime":"1:50",
				"arteryTimeStr":"1:50",
				"arriveTime":"8:20",
				"arriveTimeStr":"8:20",
				"cargoRoute":"a-b<br>b-c",
				"stopNames":"",
				"stopsNum":"3"
			}],
			"total":7,
			"offset":2,
			"limit":2,
			"current":2
		}
	};
}