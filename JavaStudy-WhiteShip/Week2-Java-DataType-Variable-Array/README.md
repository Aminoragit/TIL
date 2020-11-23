# 2 주차 :: Java 데이터 타입, 변수 그리고 배열

> > 고뇌에 지는 것은 수치가 아니다. 쾌락에 지는 것이야말로 수치다. - 파스칼

1. 프리미티브 타입 종류와 값의 범위 그리고 기본 값
2. 프리미티브 타입과 레퍼런스 타입
3. 리터럴
4. 변수 선언 및 초기화하는 방법
5. 변수의 스코프와 라이프타임
6. 타입 변환, 캐스팅 그리고 타입 프로모션
7. 1차 및 2차 배열 선언하기
8. 타입 추론, var

---

<img src="https://github.com/accidentlywoo/TIL/blob/main/images/java-data-type.png" width="66%" height="30%" display="inline-block" alt="자바 데이터 타입"/>

## 1. 프리미티브 타입 종류와 값의 범위 그리고 기본 값
1. boolean : true, false,  기본값 : false
2. byte : -2^7 ~ 2^7-1,  기본값 : 0
3. short : -2^15 ~ 2^15-1,  기본값 : 0
4. int :  -2^31 ~ 2^31-1,  기본값 : 0
5. long :  -2^63 ~ 2^63-1,  기본값 : 0L
6. float :  0x0.000002P-126f ~ 0x1.fffffeP+127f,  기본값 : 0.0f
7. double :  0x0.0000000000001P-1022f ~ 0x1.fffffffffffffP+1023,  기본값 : 0.0d 또는 0.0
8. char :  \u0000 ~ \uffff (0 ~ 2^15-1),  기본값 : \u0000
    -> 자바에서 unsigned로 동작하는 자료형

### 기본값
    필드가 선언 될 때 항상 값을 할당 할 필요는 없다. 
    선언은 되었지만 초기화되지 않은 필드는 컴파일러에 의해 적절한 기본값으로 설정된다.
    일반적으로 기본값은  데이터 타입에 따라 null또는 0이다.
    하지만, 이러한 기본값에 의존하는 것은 일반적으로 잘못된 프로그래밍 스타일로 간주된다.

    지역 변수는 약간 다르다. 컴파일러는 초기화되지 않은 지역 변수에 기본값을 할당하지 않는다.
    선언 된 지역 변수를 초기화 할 수 없는 경우 사용하기 전에 값을 할당해야한다.
    초기화되지 않은 로컬 변수에 액세스하면 컴파일 타임 오류가 발생한다.

> 자바는 전역변수 쓸 일이 있나? 무튼 전역변수와 지역변수 초기할당 내용이 다르다.

### 더 나아가기
        long타입을 사용한다고 해도 가장 큰 값은'9223372036854775807' 이다.
        이보다 더 큰 숫자가 필요하면 BigInteger를 기억하세요.
        하지만, 일반적인 연산자를 사용할 수 없다.
        대신 '.add()', '.subtract()', '.multiply()', '/divide()' 메소드가 제공괴고
        매개변수 또한 BigInteger를 받는다.

### 특징 
- Java 프로그래밍 언어는 정적으로 형식화되어 있으므로 모든 변수를 사용하기 전에 먼저 선언해야한다. 변수의 타입과 이름을 지정하는 것이 포함된다.
- OS에 따라 자요형의 길이가 변하지 않는다
- 비객체 타입이라서 null을 가질 수 없다.

## 2. 프리미티브 타입과 레퍼런스 타입
- Reference Type 
    : 참조형은 기본적으로 ```java.lang.Object``를 상속 받으면 참조형이 된다.
      또한 선언한 자료형이 기본형이 아닌 경우 참조형이 된다고 보면 된다.
      참조형에는 1. 클래스형 , 2. 인터페이스 형 3. 배열 형이 있다.

## 3. 리터럴
        기본 유형의 변수를 초기화 할 때 키워드가 사용되지 않는다는 것을 눈치 챘겠찡?
        primitive 타입은 언어에 내장 된 특수 데이터 유형이다. 
        클래스에서 생성된 객체가 아니다.
        리터럴은 고정 된 값의 소스 코드의 표현
        -> 리터럴은 계산없이 코드에서 직접표현된다.

### 정수 리터럴
        정수 리터럴은 long문자 'L'또는 'l'로 끝나는 경우. 
        기본적으로 int 유형이다.
        가독성을 위해 'L'을 사용하는 것이 좋다.
        정수 리터럴은 다음 숫자 체계로 표현할 수 있다.
 - 10 진수 : 10 진수, 숫자 0에서 9까지의 숫자로 구성된다.
 - 16 진수 : 숫자 0부터 9까지와 A에서 F까지의 문자로 구성된 16진수
 - 2 진수 : 숫자 0과 1로 구성(Java SE 7 이상)

        범용 프로그래밍의 경우 십진법이 유일한 숫자 체계일것이다.
        그러나 다른 숫자 체계를 사용해야하는 경우, 16잔수는 접두사 0x, 
        바이너리는 0b를 나타난다.

```
// 숫자 26, 십진수 
int decVal = 26; 
// 숫자 26, 16 진수 
int hexVal = 0x1a; 
// 숫자 26, 이진수 
int binVal = 0b11010;
```
### 부동 소수점 리터럴
        부동 소수점 리터럴은 float 문자 또는 F,f로 끝나는 유형이다.
        기본형은 double이고, 선택적으로 D,d로 끝날 수 있다.

### 문자와 문자열 리터럴
        char또는 String 유형의 모든 유니 코드(UTF-16) 포함할 수 있다.
        편집기 및 파일 시스템에서 허용할 경우 이러만 문자를 코드에서 직접사용할 수 있다.
        그렇지 않은 경우, '\u0108'와 같은 '유니코드 이스케이스'를 사용할 수 있다.

        char은 작은따옴표(')를 사용하고 리터럴에는 큰따옴표(")를 사용해라.

        유니코드 이스케이프 시퀀스는 char, String 리터럴 뿐만아니라 프로그램의 다른 곳에서 사용할 수 있다. (ex. 필드 이름)

        자바는 특별한 이스케이스를 지원한다. : \b(백 스페이스), \t(탭), \n(라인 피드)
        \f(폼 피드), \r(캐리지 리턴), \", \', \\(백슬럿)

        null은 primitive type을 제외한 모근 변수에 할당될 수 있다. 
        null은 프로그램에서 일부 개체를 사용할 수 없음을 나타내는 마커로 자주 사용된다.

        클래스 리터럴이라는 특수한 종류의 리터럴도 있다. 
        이는 타입이름을 취하고, '.class'를 추가해 형성된다.
        String.class 이것은 Class타입 자체를 나타내는 객체(타입)를 참조한다.

### 숫자 리터럴에서 밑줄 문자 사용
        Java SE 7이상에서 '_'숫자 리터럴의 숫자 사이에 사용 가능하다.
        이는 코드의 가독성을 높일 수 있다.
```
creditCardNumber = 1234_5678_9012_3456L;
int x3 = 5_______2;
```
        사용할 수 없는 위치도 있다
```
 // 소수점 옆에 사용 불가
float pi1 = 3_.1415F; 
float pi2 = 3._1415F; 

// 접미사 앞에
socialSecurityNumber1 = 999_99_9999_L;

//라터럴 끝에
int x2 = 52_;

// 기수 접두사
int x4 = 0_x52; 

// 기수 접두사 숫자 시작,끝 부분
X5 = 0x_52;
INT의 X7 = 0x52_;
```

## 4. 변수 선언 및 초기화하는 방법
        변수 이름운 대소문자를 구분한다.
        문자,$,_로 시작하는 무제한 길이의 유니 코드 문자 및 수자 시퀀스가 될 수 있다.
        $는 관례 상 전혀 사용되지 않는다. _로 시작도 권장하지 않는다.

        변수의 이름을 선택할 때 암호화된 약어 대신 전체 단어를 사용해라
        이는 가독성을 높여준다.

        이름이 한단어로 구성된 경우 모든 철자를 소문자로 입력해라
        두개이상의 단어는 후속단어의 첫글자를 대문자로 표시해라(카멜)

### 변수의 종류
1. 인스턴스 변수 (비 정적 필드)
        static키워드 없이 선언 된 필드에 개별 상태를 저장한다.
        비 정적 필드는 해당값이 클래스의 각 인스턴스(즉, 각 객체에 대해 고유함)에 고유하기 때문에 인스턴스 변수라고도 한다.

2. 클래스 변수(static 필드)
        static키워드 붙은 변경자. 
        이것은 컴파일러에게 클래스가 몇 번 인스턴스화되었는지에 관계없이 유일하게 존재 하는 복사본임을 알려준다.

3. 로컬 변수
        객체가 필드에 상태를 저장하는 방법과 유사하게 메서드는 종종 로컬 변수에 임시 상태를 저장한다. 지역 변수 선언 구문은 필드 선언과 유사하다. 
        지역변수는 블록 안에서만 유효하고, 나머지 구역에서 접근할 수 없다.

4. 매개변수
        매개 변수는 항상 필드가 아닌 변수로 분류된다는 것을 기억하자
        
### Expression과 Statement
        Expression 은 언어의 문법에 따라 구성되는 변수, 연산자 및 메소드 호출들로
        이루어진 구조체의 단일 값으로 평가되는 것이다.
        자바를 사용하면 표현식에서 데이터 유형이 다른 복잡한 표현식을 구성할 수 있다.
        연산자 우선순위 개념이 있기 때문에 유의해야한다.

        Statement 는 문장과 거의 동일하다. 
        statement는 세미콜론으로 표현식을 종료하여 다음 유형의 표현식을 statement로 만들 수 있다.
- 할당식
- ++ 또는 --
- 메서드 호출
- 객체 생성 표현식
        표현문(Expression Statement) 뿐만아니라, 선언문 및 제어 흐름 문 두 종류가 있다.

## 5. 변수의 스코프와 라이프타임


## 6. 타입 변환, 캐스팅 그리고 타입 프로모션 :fire:

## 7. 1차 및 2차 배열 선언하기

## 8. 타입 추론, var :fire:

### 참고 블로그
- [jdm님 블로그](https://jdm.kr/blog/213)
- [공홈 Java Tutorials](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)