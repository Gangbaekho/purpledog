# purpledog 백앤드 개발 지원자 김진수 과제 제출

## 과제 설명

### H2 사용
데이터 베이스로는 인메모리인 H2 데이터베이스를 사용하였습니다.
이에 따라 따로 데이터베이스 설정없이 애플리케이션을 실행시켜주시면 될 것 같습니다.

### JPA 사용
데이터 퍼시스턴트 프레임워크로 JPA를 이용하여 과제를 구현하였습니다.
ddl-auto : update를 사용하여 자동으로 테이블이 생기지만
User Table에 대한 ddl을 명시하라고 되어있기 때문에 ddl sql을 제공하겠습니다.

create table user (
id bigint not null,
email varchar(255),
password varchar(255),
primary key (id)
) engine=InnoDB;

alter table user add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);

### 추가 설명

1. 과제에 따르면 user는 id와 password를 가진다고 말씀해주셨습니다.
JPA를 사용함에 따라 식별키가 필요했으며 이를 주로 id로 표현하기 때문에
요청주신 id는 email로 대체하여 표현하여습니다.

2. Controller에 관련된 요청과 응답 데이터는 Dto를 만들어서 구현하였습니다.
현재는 비슷한 요청과 응답이 많아 세세히 구분할 필요는 없지만,
앞으로의 변경 가능한 부분이라고 생각되었기 때문에 이를 유연하게 대처하기 위해
Dto를 따로 만들어서 표현하였습니다.

3. Get 요청은 보통 @GetMapping 어노테이션을 사용하나,
유저 정보를 얻기 위해 email과 password를 받도록 하였습니다.
이에 따라 url에 password가 노출되지 않도록 데이터를 패칭하는 요청이지만
@PostMapping을 이용하여 유저 데이터를 패칭하도록 하였습니다.

감사합니다.


