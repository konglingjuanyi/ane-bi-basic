module.exports = {
	getUsers : getUsers,
	getUsers2 : getUsers2,
	getUser : getUser,
	getExtradays : getExtradays,
	getCodesWithPage : getCodesWithPage,
	getCodesByType : getCodesByType,
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

function getExtradays() {
	return {
		"status" : "SUCCESS",
		"result" : {
			"result" : [ {
				"id" : 0,
				"siteName" : "上海分拨中心",
				"siteProperty" : "一级分拨中心分拨",
				"type" : "分拨",
				"agingType" : "干线时效",
				"extraDays" : -1,
				"memo" : "233",
			}, {
				"id" : 1,
				"siteName" : "杭州网点",
				"siteProperty" : "二级网点",
				"type" : "网点",
				"agingType" : "交件时效",
				"extraDays" : 2,
				"memo" : "nono",
			}],
			"total" : 7,
			"offset" : 2,
			"limit" : 2,
			"current" : 2
		}
	};	
}
function getCodesWithPage() {
	return {
		"status" : "SUCCESS",
		"result" : {
			"result" : [ {
				"id" : "1",
				"codeType" : "car_type",
				"description" : "车型",
				"codeName" : "9.6",
			}, {
				"id" : "2",
				"codeType" : "car_type",
				"description" : "车型",
				"codeName" : "17.5",
			}],
			"total" : 7,
			"offset" : 2,
			"limit" : 2,
			"current" : 2
		}
	};	
}
function getCodesByType() {
	return {
		"status" : "SUCCESS",
		"result" : {
			"result" : [ {
				"id" : "1",
				"codeType" : "aging_type_all",
				"description" : "全部时效类型",
				"codeName" : "交件时效",
			}, {
				"id" : "2",
				"codeType" : "aging_type_all",
				"description" : "全部时效类型",
				"codeName" : "派件时效",
			},{
				"id" : "3",
				"codeType" : "aging_type_all",
				"description" : "全部时效类型",
				"codeName" : "干线时效",
			}]
		}
	};	
}