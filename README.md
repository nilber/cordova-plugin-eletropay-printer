# Cordova EletroPay Printer Service plugin - BETA VERSION

## TL;DR
This is a Cordova plugin for Android that printer POS eletropay.

## Using the plugin
First, you need to install it. If you're using Ionic:

`ionic cordova plugin add https://github.com/nilber/cordova-plugin-eletropay-printer.git`

If you're using Cordova:

`cordova plugin add https://github.com/nilber/cordova-plugin-eletropay-printer.git`

In the code, you would like this:

```
constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen) {
        platform.ready().then(() => {
            var eletroPayPrinterService = new EletroPayPrinterService();
            eletroPayPrinterService.start(
                function(msg) {
                    console.log(msg);
                    eletroPayPrinterService.add_command(["Line A \n Line B \n\n\n Line C\n\n\n..........", 24, 0, 0],
                        function(msg) {
                            console.log(msg);
                            eletroPayPrinterService.printer(
                                function(msg) {
                                    console.log(msg);                                  
                                },
                                function(err) {
                                    console.log(err);
                                }
                            );
                        },
                        function(err) {
                            console.log(err);
                        }
                    );
                },
                function(err) {
                    console.log(err);
                }
            );

        });
    }
```

If you're using the newest (currently 3) version of Ionic, then you would have to add this line: `declare var EletroPayPrinterService: any;` after the imports in `app.component.ts` (or any other file where you'll use the plugin) before actually using it. If you're using Ionic 1, you don't need to do this.

As a final note, make sure you're accessing the plugin after the `platform.ready()` fires, just so you make sure that the plugin is ready for use.
