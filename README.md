# 알라딘

## 요구 사항

- 사용자
    - [ ]  사용자는 구매자와 판매자로 나누어 진다.
    - [ ]  구매자와 판매자는 아이디를 등록할 수 있고 등록한 아이디로 로그인할 수 있어야 한다.
    - [ ] 구매자와 판매자는 기본정보를 입력하여 가입한다.(이름,전화번호,이메일) 
            - 구매자는 추가정보로 배송지를 입력
            - 판매자는 추가정보로 주민등록 이미지를 등록
    - [ ]  구매자는 장바구니에 책을 찜할 수 있다. (구매 x)
    - [ ]  구매자는 자신의 찜 목록을 볼 수 있다.
    - [ ]  판매자는 책 목록을 보고 자신이 판매하고 싶은 책의 수량,가격을 등록하여 판매할 수 있다.
    - [ ]  판매자는 자신의 판매책 목록을 볼 수 있다.



- 책
    - [ ] 사이트에서 판매,구매되는 책은 사전에 미리 정의된 목록만 판매,구매될 수 있다.(외부 api에서 제공하는 목록)
           ex) 이펙티브자바,클린코드,DDD start 등으로 책의 정보목록을 제공 (판매자는 정의된 책 종류만 등록하여 판매가능)    
    - [ ] 책 목록에서 제공하는 정보는 책의 이름, 저자, 출판사 정보, 카테고리, 새책 가격이다.
    - [ ] 책은 새책판매, 중고책 판매 두가지 판매가 있다.
    - [ ] 중고책 판매 가격은 판매자가 마음대로 정해서 등록할 수 있다. (단 새책가격은 넘을 수 없다.)
    - [ ] 판매목록에 등록되는 책은 판매자마다 다른 수량,다른 가격으로 등록할 수 있다.
            ex) 최유성님 이펙티브 자바 10권 15_000원
                  이호진님 이펙티브 자바 7권  14_000원
    - [ ] 판매자는 자신이 올린 책에 이벤트 기간을 정할 수 있다.
            ex) 5월 2일 ~ 5일까지 5%할인

- 찜(주문예약)
    - [ ]  찜은 책을 구매하기전 예약하는 행위이다.
    - [ ]  구매자가 찜을 하면 판매자가 등록한 책의 수량이 줄어든다.
    - [ ]  찜한 책의 총합은 15개를 넘을 수 없다.
    - [ ]  책을 5권 이상 찜하면 5%의 할인율이 적용된다.
    - [ ]  총 구매 수가 3권 이하일 경우 배송비 2500원이 추가된다.
    - [ ]  찜 목록에서는 구매한 책의 목록, 찜한 수량, 일자, 할인이 적용된 가격, 적용안된 가격이 보여진다. 
    - [ ] 수량에 따른 할인율과 판매자의 이벤트에 대한 할인율은 중복 적용이 가능하다. 

## 용어 사전
| 한글명 | 영문명 | 설명  |
| --- | --- | --- |
| 구매자 | Buyer | 구매자는 찜을 할수 있는 사람이다. (아이디,이름,전화번호,이메일,배송지) 정보를 입력한다.  |
| 판매자 | Seller | 판매자는 도서등록을 할수 있는 사람이다. (아이디,이름,전화번호,이메일,주민등록이미지) 정보를 입력한다.  |
| 장바구니 | ShoppingBasket | 장바구니는 구매자가 책을 찜하면 등록이 된다. (최대 15권, 하루가 넘어가면 내역이 삭제된다, 동일 판매자에게서 동일 책 5권 이상을 찜하면 해당 책은 10% 할인이 적용된다, 여러종류의 책 5권 이상을 찜하면 5% 할인이 적용된다 중복적용이 안되며 이중 금액이 할인금액이 적은것으로 적용된다. 총 구매수가 3권 이하일 경우 2500원이 추가된다. 목록, 수량, 일자, 할인이 적용된 가격, 적용 안된 가격이 보여진다.) |
| 책 | Book | 책은 사전에 미리 정의된 목록(API 제공, 책의 이름, 저자, 출판사 정보, 카테고리) 만 판매, 구매될수 있다.|
| 등록 | Enrollment | 판매자가 판매할 책을 등록하는 행위이다. 책들의 수량과 책들의 가격, 이벤트 기간과 이벤트 할인율을 추가할수 있다. 장바구니 이벤트와는 중복 적용된다.|
| 등록된책 | RegisteredBook | 각각 1권씩 등록되며 금액과 찜 여부를 알고 있다.|
| 찜된책 | ReservationBook | 주문예약이 된 책을 의미한다. 등록된 책을 가져가며 |

## 모델링