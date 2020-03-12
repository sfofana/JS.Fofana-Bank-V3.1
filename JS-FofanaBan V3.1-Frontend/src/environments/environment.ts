// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  connection: "http://localhost:9000/connection",
  authUrl: "http://localhost:9000/auth-service/api/v1/login",
  accountUrl: "http://localhost:9000/account-service/api/v1/account",
  depositUrl: "http://localhost:9000/deposit-service/api/v1/deposit",
  withdrawUrl: "http://localhost:9000/withdraw-service/api/v1/withdraw",
  transferUrl: "http://localhost:9000/transfer-service/api/v1/transfer"
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
