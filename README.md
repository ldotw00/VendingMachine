# Vending Machine (음식 주문 자판기)

---

<br/>

## 조원 소개

안녕하세요, 저희는 **201901681 백창민**, **201701721 황병화**, **201701710 정민성**으로 구성된 팀입니다.

<br/>

## 자판기 구현 과정

저희는 먼저 **GitHub**의 Projects 탭을 이용하여 "To Do List"를 작성한 후에 역할 분담을 하였습니다.  
그리디 알고리즘을 이용하여 가격을 계산하는 **코드**를 작성한 후, **Swing**을 이용하여 **GUI**를 구성하였습니다.  
이후, GUI에 가격 계산 코드를 합쳐서 **자판기의 기본적인 틀**을 완성하였습니다.  
**다양한 케이스를 적용**해보면서 오류가 발생하는 부분들은 **조원들과 의논**하여 단계적으로 **수정**하였으며,  
마지막으로 디자인적인 요소를 최적화하여 **사용성을 개선**하였습니다.  
결과물은 GitHub의 __*VendingMachine.java*__와 __*Set.png*__ 이며, 프로젝트 src 풀더안에  
*VendingMachine.java*를 넣고, image 풀더를 생성하여 *Set.png*를 넣으면 **자판기가 실행**됩니다.

<br/>

## 자판기 실행 화면

1. 자판기 실행 화면

   자판기를 실행하면 처음으로 볼 수 있는 화면입니다.  
   3개의 주문 메뉴를 확인할 수 있으며, 메뉴별 원하는 수량을 선택할 수 있고,  
   투입 금액에 자신이 내고자 하는 금액을 작성하여 구매버튼을 누르면, 잔돈을 확인할 수 있습니다.

   <center><img width="550" alt="1 자판기실행화면" src="https://user-images.githubusercontent.com/62412198/80120895-98b15a00-85c6-11ea-933c-d841df330c78.png"></center>

   

2. 메뉴 수량 선택

   수량 선택은 JSpinner를 이용하여 구현하였습니다. 메뉴 별 원하는 수량을 선택한 후,  
   선택완료 버튼을 누르면 총 구매 금액이 표시가 됩니다. 메뉴 별 최대 구매 가능 수량은 10으로 설정해두었으며,  
   구매 금액은 JTextField를 이용하여 구현하였고, 임의로 수정하지 못하게 설정하였습니다.

   <center><img width="550" alt="2 메뉴수량선택" src="https://user-images.githubusercontent.com/62412198/80120920-a1a22b80-85c6-11ea-900c-0e7f682c8254.png"></center>

   

3. 금액 투입 후 구매

   구매 금액을 확인 한 후에, 투입할 금액을 작성합니다.  
   작성한 후에 구매 버튼을 누르면, 구매 금액과 투입 금액을 비교하여 알림창이 나타나게 됩니다.  
   지금 화면에서는 구매 금액보다 투입 금액이 많기 때문에 잔돈 확인 버튼이 활성화 되었습니다.


   <center><img width="550" alt="3 금액투입후구매" src="https://user-images.githubusercontent.com/62412198/80118023-d3b18e80-85c2-11ea-8c62-14fa60f6e408.png"></center>

   


4. 잔돈 확인

   활성화된 잔돈 버튼을 누르면 잔돈이 자동으로 계산되어 알림창에 뜨게 됩니다.


   <center><img width="550" alt="4 잔돈확인" src="https://user-images.githubusercontent.com/62412198/80118029-d57b5200-85c2-11ea-8bcd-709905115a21.png"></center>

   


5. 금액이 부족한 경우

   예외적인 경우를 고려하여, 만약 구매 금액보다 투입 금액이 적을 경우에는 구매 버튼을 눌렀을 때  
   오류 메세지 창을 출력하여 투입 금액을 수정하도록 유도합니다.


   <center><img width="550" alt="5 금액이부족한경우" src="https://user-images.githubusercontent.com/62412198/80118035-d7451580-85c2-11ea-92e2-78634feedbac.png"></center>

   


6. 금액을 투입하지 않은 경우

   만약, 투입 금액을 넣지 않고 구매 버튼을 누르면 위와 마찬가지로 오류 메세지 창을 출력하여  
   투입 금액을 입력하도록 유도합니다.


   <center><img width="550" alt="6 금액을투입하지않은경우" src="https://user-images.githubusercontent.com/62412198/80118036-d7451580-85c2-11ea-9ceb-b8c280c8fdad.png"></center>

   


7. 구매 금액과 투입 금액이 같은 경우

   만약에 구매 금액과 투입 금액이 같은 경우에는, 잔돈 버튼을 눌렀을 때 아래와 같은 알림창을 출력하게 됩니다. 


   <center><img width="550" alt="7 구매금액과투입금액이같은경우" src="https://user-images.githubusercontent.com/62412198/80118037-d7ddac00-85c2-11ea-9afe-1d3a8bbf048b.png"></center>

<br/>

---

## 지금까지

약 2주라는 시간에 걸쳐 JAVA를 이용하여 음식을 주문하는 자판기를 구현하였습니다.  
팀원들과 역할을 분담하고 서로 도움을 주고 받으며 자판기를 완성하는 과정을 통해서,  
Java의 다양한 기능을 접하게 되었고, GitHub를 활용하여 조별 과제를 보다 원활하게 수행할 수 있었습니다.  
지금까지 저희 팀의 자판기 구현 과정과 결과 화면에 대한 글이었습니다. 감사합니다.

---

<br/>