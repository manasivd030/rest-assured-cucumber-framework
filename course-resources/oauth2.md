# OAuth 2.0 with RestAssured

***

![Static Badge](https://img.shields.io/badge/imgur-black?logo=imgur&logoSize=auto&style=for-the-badge)
![Static Badge](https://img.shields.io/badge/OAuth2.0-%23EB5424?logoSize=auto&style=for-the-badge)
![Static Badge](https://img.shields.io/badge/postman-%23FF6C37?logo=postman&logoColor=white&logoSize=auto&style=for-the-badge)

## Resources for this lecture

***
We will use Imgur API for OAuth2.0. You can find the API
documentation [here](https://apidocs.imgur.com/#authorization-and-oauth).

## Steps to generate OAuth2.0 token for Imgur API

***

1. Go to [Imgur](https://imgur.com/register) and create an account.
2. [Register your application](https://api.imgur.com/oauth2/addclient) Register your application using the postman
   callback URL: <https://www.getpostman.com/oauth2/callback>
3. Get the client ID and client secret. Note: Do not forget to use the above callback URL.
4. In Postman, under the main request builder panel, click the `Authorization tab`. Click the `Get New Access Token`
   button. Following are the details to fill in the form:
    - Token Name: Practice Token(You can give any name)
    - Grant Type: Authorization Code
    - Callback URL: <https://www.getpostman.com/oauth2/callback>
    - Auth URL: <https://api.imgur.com/oauth2/authorize>
    - Access Token URL: <https://api.imgur.com/oauth2/token>
    - Client ID: Your client ID
    - Client Secret: Your client secret
    - Scope: Leave it blank
    - Client Authentication: Send client credentials in body

5. Click the `Request Token` button. You will be redirected to the Imgur login page. Enter your credentials and click
   the `Allow` button.
6. You will be redirected to the callback URL. Copy the access token and refresh token.

The refresh token is used to get a new access token when the current access token expires. You can keep the refresh
token in a safe place.

> Recommended: Do not share your access token and refresh token with anyone. Keep them in your environment variables or
> in a file which must be included in `.gitignore`.

## Imgur API Endpoints used in this lecture

***

- `POST` [Generate Access Token](https://apidocs.imgur.com/#3f80c836-8f49-4fb1-95a7-a4b058265d72)
- `POST` [Image Upload](https://apidocs.imgur.com/#c85c9dfc-7487-4de2-9ecd-66f727cf3139)
- `DELETE` [Image Delete(Authed)](https://apidocs.imgur.com/#ca48883b-6964-4ab8-b87f-c274e32a970d)

## Test Class for this lecture

***

- [ImgurOAuth2Example.java](../src/test/java/practiceTests/auth/ImgurOAuth2ExampleTests.java)

## References

***

- [OAuth2.0](https://oauth.net/2/)
- [Imgur API](https://apidocs.imgur.com/#authorization-and-oauth)

***
