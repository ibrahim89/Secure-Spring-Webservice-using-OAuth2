# Secure-Spring-Webservice-using-OAuth2
Spring Security Implementation using Oauth2
# How to Use the service URLs:
Attempt to access resources [REST API] without any authorization [will fail of-course].
1. GET http://localhost:8080/spring-security-oauth2-example/user/

Ask for tokens[access+refresh] using HTTP POST on /oauth/token, with grant_type=password,and resource owners credentials as req-params. Additionally, send client credentials in Authorization header.

2.POST http://localhost:8080/spring-security-oauth2-example/oauth/token?grant_type=password&username=ibrahim&password=ibrahim

Ask for a new access token via valid refresh-token, using HTTP POST on /oauth/token, with grant_type=refresh_token,and sending actual refresh token. Additionally, send client credentials in Authorization header.

3. POST http://localhost:8080/spring-security-oauth2-example/oauth/token?grant_type=refresh_token&refresh_token=094b7d23-973f-4cc1-83ad-8ffd43de1845

Access the resource by providing an access token using access_token query param with request.

4. GET http://localhost:8080/spring-security-oauth2-example/user/?access_token=e583eda3-20f1-45dc-b9d4-f87650d546c6
