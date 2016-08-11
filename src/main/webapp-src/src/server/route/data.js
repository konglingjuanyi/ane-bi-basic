module.exports = {
	getUsers : getUsers,
	getUsers2 : getUsers2,
	getUser : getUser,
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