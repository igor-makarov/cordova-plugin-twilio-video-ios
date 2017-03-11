var exec = require('cordova/exec');

exports.openRoom = function(token, room, success, error) {
    exec(success, error, "TwilioVideoIOS", "openRoom", [token, room]);
};
