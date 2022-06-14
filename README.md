# 반성문
리팩토링을 진행할 과제만 나열할게 아니라 반성을 했어야 했다...<br>
Effective Java 3/E 스터디와 인프런 김영한님 강의를 보고 내 코딩에 대한 나쁜 습관들을 고쳐야겠다. <br>

### 1️⃣ 테스트의 부재 <br>
테스트 소스가 1도 없다... <br>
그동안 TDD에 대한 내용을 부정해오며 왜 해야하는지 필요성을 느끼지 못하였다. <br>
테스트에 많은 시간을 쏟았긴 했지만... <br>
사용자의 행위, 패턴 등을 알 수 없고 어떠한 상황에서 벌어질지 모른다고 판단하여 <br>
코드로 작성하는 테스트를 부정해왔던건 사실이다. <br>
솔직히 아직도 잘 모르겠다... <br>
하지만, 이번에 인프런 김영한님께서 모든 코드에 테스트를 작성하시는것을 보고 TDD에 대해서 <br>
진지하게 공부를 해보고 다시 생각하기로 했다.<br>


### 2️⃣ VO와 DTO의 분리 <br>
```java
@PostMapping("/adminListAjax")
@ResponseBody
public List<AdminVO> adminListAjax(@ModelAttribute AdminVO adminVO) throws Exception{
    return adminService.selectAdminListPaging(adminVO);
}
```
`VO`의 불필요한 내용까지 return 해주므로 보여줄 값에 대한 `DTO`를 만들어 return 해주자!

### 3️⃣ 형식적인 service 사용 <br>
단지 조회만 하는 기능을 굳이 `service`에 또 만드는 행위는 한번쯤 다시 생각해봐야 겠다.


### 4️⃣ 이유없는 필드주입
```java
@Resource
private AdminService adminService;

@Resource
private AuthService authService;
```
생성자 주입, 세터 주입, 필드 주입에 대한 이론을 모르는건 아니였는데 그렇다고 뭔가 이유가 있어서 <br>
필드 주입으로 작성했던것도 아니다... 반성이 필요할 것 같다. <br>

<br>
까도까도 반성할게 계속 나온다... 끔찍한... <br>
Exception...으로 다 던지고... catch문은 처리도 안하고.... <br>
System.out.println은 왜 이렇게 많은지... logger 어디다 팔아먹고... <br>
SRP, OCP를 다 어긴 메소드들이...여기저기... <br>
부끄러운 소스들이라 숨기고 쉽지만 계속 숨기면 발전이 없을것 같아서 오픈하고 계속 반성하기로 하자!<br>
