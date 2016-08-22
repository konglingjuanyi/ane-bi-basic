var router = require('express').Router();
var data = require("./data");

module.exports = router;


router.get("/api/users", function(req, res, next) {
   buildResponse( res , data.getUsers() );
});

router.get("/api/users2", function(req, res, next) {
   buildResponse( res , data.getUsers2() );
});


router.get("/api/user/:userId", function(req, res, next) {
   buildResponse( res , data.getUser() );
});


router.post("/api/user", function(req, res, next) {
    buildResponse( res , buildSuccessResponse());
});

router.delete("/api/user/:userId", function(req, res, next) {
   buildResponse( res , buildSuccessResponse());
});

router.post("/api/user/:userId", function(req, res, next) {
   buildResponse( res , buildSuccessResponse());
});

router.get("/sidebar", function(req, res, next) {
   res.render("public/admin-sidebar");
});

router.get("/user-example", function(req, res, next) {
   res.render("user-example");
});

router.get("/role", function(req, res, next) {
   res.render("role");
});

router.get("/resource", function(req, res, next) {
   res.render("resource");
});

router.get("/department", function(req, res, next) {
   res.render("department");
});

function buildResponse(res, result) {
    res.status(200)
        .send(result)
        .end();
}

function buildSuccessResponse(result) {
    return {
        status: 'SUCCESS',
        result: result
    };
}

function buildErrorResponse(result, args) {
    args = args || [];
    return {
        status: 'ERROR',
        result: {
            code: result,
            arguments: args
        }
    };
}