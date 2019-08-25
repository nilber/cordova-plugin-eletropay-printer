var exec = cordova.require('cordova/exec');

var EletroPayPrinterService = function() {
    console.log('EletroPayPrinterService instanced');
};

EletroPayPrinterService.prototype.show = function(msg, onSuccess, onError) {
    var errorCallback = function(obj) {
        onError(obj);
    };

    var successCallback = function(obj) {
        onSuccess(obj);
    };

    exec(successCallback, errorCallback, 'EletroPayPrinterService', 'show', [msg]);
};


EletroPayPrinterService.prototype.start = function(onSuccess, onError) {
    var errorCallback = function(obj) {
        onError(obj);
    };

    var successCallback = function(obj) {
        onSuccess(obj);
    };

    exec(successCallback, errorCallback, 'EletroPayPrinterService', 'start', []);
};

EletroPayPrinterService.prototype.printer = function(onSuccess, onError) {
    var errorCallback = function(obj) {
        onError(obj);
    };

    var successCallback = function(obj) {
        onSuccess(obj);
    };

    exec(successCallback, errorCallback, 'EletroPayPrinterService', 'printer', []);
};

// obj PrinterCommand(String text, int size,int type, int alignment)
EletroPayPrinterService.prototype.add_command = function(printerCommand, onSuccess, onError) {
    var errorCallback = function(obj) {
        onError(obj);
    };

    var successCallback = function(obj) {
        onSuccess(obj);
    };

    exec(successCallback, errorCallback, 'EletroPayPrinterService', 'add_command', printerCommand);
};


if (typeof module != 'undefined' && module.exports) {
    module.exports = EletroPayPrinterService;
}