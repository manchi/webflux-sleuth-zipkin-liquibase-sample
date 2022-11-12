# Getting Started

### Executing using Httpie

Pre-requisites:

```shell
brew install httpie
```

```shell
 http -v post :8083/v1/person --raw '{"firstName":"john", "lastName":"smith"}'
POST /person HTTP/1.1
Accept: application/json, */*;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 40
Content-Type: application/json
Host: localhost:8083
User-Agent: HTTPie/3.2.1

{
    "firstName": "john",
    "lastName": "smith"
}


HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Thu, 21 Jul 2022 12:54:37 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "john",
    "lastName": "smith",
    "middle": null
}
```


```shell
~/study/spring-boot-study                                                                                                                                                                                              
> http -v post :8083/v1/person --raw '{"firstName":"john", "lastName":"smith", "middle":"MNU"}'
POST /person HTTP/1.1
Accept: application/json, */*;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 56
Content-Type: application/json
Host: localhost:8083
User-Agent: HTTPie/3.2.1

{
    "firstName": "john",
    "lastName": "smith",
    "middle": "MNU"
}


HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Thu, 21 Jul 2022 12:55:28 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "john",
    "lastName": "smith",
    "middle": "MNU"
}
```

```shell
~/study/spring-boot-study                                                                                                                                                                                              
> http -v post :8083/v1/person --raw '{"firstName":"john", "lastName":"smith"}'                
POST /person HTTP/1.1
Accept: application/json, */*;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 40
Content-Type: application/json
Host: localhost:8083
User-Agent: HTTPie/3.2.1

{
    "firstName": "john",
    "lastName": "smith"
}


HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Thu, 21 Jul 2022 12:55:44 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "john",
    "lastName": "smith",
    "middle": null
}

```


```shell
~/study/spring-boot-study                                                                                                                                                                                              
> echo  '{"firstName":"john", "lastName":"smith"}'| http -v post :8083/v1/person
POST /person HTTP/1.1
Accept: application/json, */*;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 41
Content-Type: application/json
Host: localhost:8083
User-Agent: HTTPie/3.2.1

{
    "firstName": "john",
    "lastName": "smith"
}


HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Thu, 21 Jul 2022 12:57:40 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "john",
    "lastName": "smith",
    "middle": null
}

```


```shell
~/study/spring-boot-study                                                                                                                                                                                              
> echo  '{"firstName":"john", "lastName":"smith"}'| http -v post :8083/v1/person
POST /person HTTP/1.1
Accept: application/json, */*;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 41
Content-Type: application/json
Host: localhost:8083
User-Agent: HTTPie/3.2.1

{
    "firstName": "john",
    "lastName": "smith"
}


HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Thu, 21 Jul 2022 12:57:47 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "john",
    "lastName": "smith",
    "middle": null
}

```


```shell
~/study/spring-boot-study                                                                                                                                                                                              
> echo  '{"firstName":"john", "lastName":"smith","one":"two"}'| http -v post :8083/v1/person
POST /person HTTP/1.1
Accept: application/json, */*;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 53
Content-Type: application/json
Host: localhost:8083
User-Agent: HTTPie/3.2.1

{
    "firstName": "john",
    "lastName": "smith",
    "one": "two"
}


HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Thu, 21 Jul 2022 12:58:00 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "john",
    "lastName": "smith",
    "middle": null
}

```

```shell
~/study/spring-boot-study                                                                                                                                                                                              
> echo  '{"firstName":"john", "lastName":"smith","one":"two", "middle":"none"}'| http -v post :8083/v1/person
POST /person HTTP/1.1
Accept: application/json, */*;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 70
Content-Type: application/json
Host: localhost:8083
User-Agent: HTTPie/3.2.1

{
    "firstName": "john",
    "lastName": "smith",
    "middle": "none",
    "one": "two"
}


HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Thu, 21 Jul 2022 12:58:13 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "john",
    "lastName": "smith",
    "middle": "none"
}
```

```shell
> echo  '{"firstName":"john", "lastName":"smith","one":"two"}'| http -v post :8083/v1/person 
POST /v1/person HTTP/1.1
Accept: application/json, */*;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 53
Content-Type: application/json
Host: localhost:8083
User-Agent: HTTPie/3.2.1

{
    "firstName": "john",
    "lastName": "smith",
    "one": "two"
}


HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Thu, 21 Jul 2022 13:01:18 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "john",
    "lastName": "smith",
    "middle": null
}



~/study/spring-boot-study                                                                                                                                                                                              
> echo  '{"firstName":"john", "lastName":"smith"}'| http -v post :8083/v1/person 
POST /v1/person HTTP/1.1
Accept: application/json, */*;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Content-Length: 41
Content-Type: application/json
Host: localhost:8083
User-Agent: HTTPie/3.2.1

{
    "firstName": "john",
    "lastName": "smith"
}


HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Thu, 21 Jul 2022 13:01:24 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "firstName": "john",
    "lastName": "smith",
    "middle": null
}

```


```shell
printf '{
    "firstName": "aaa",
    "middleName": "bbb",
    "lastName": "ccc"
}'| http  --follow --timeout 3600 POST 'http://localhost:8083/v1/person' \
 Content-Type:'application/json'
 

{
    "firstName": "aaa",
    "lastName": "ccc",
    "middleName": "bbb",
    "city": null
}
```


```shell
curl --location --request POST 'http://localhost:8083/v1/person' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "aaa",
    "middleName": "bbb",
    "lastName": "ccc"
}'

{
    "firstName": "aaa",
    "lastName": "ccc",
    "middleName": "bbb",
    "city": null
}
```


```shell
curl --location --request POST 'http://localhost:8083/v2/person' \
--header 'Content-Type: application/json' \
--data-raw '{
  "firstName":"aaa",
  "middleName":"bbb",
  "lastName":"ccc",
  "city":"bangalore"
}'

{
    "firstName": "aaa",
    "lastName": "ccc",
    "middleName": "bbb",
    "city": "bangalore"
}
```