# GodOfJava

1. String 클래스와 StringBuilder, StringBuffer 클래스의 차이를 정리해주세요  
* String 클래스 : 자바 1.5 이상부터 + 연산이 StringBuilder의 append()로 변환되어 수행되었지만, 반복문에 들어가는 경우 기존의 방식인 불변객체인 String 인스턴스를 새롭게 생성하면서 +연산을 수행한다.
* StringBuilder, StringBuffer 클래스: 가장 큰 차이점으로 멀티쓰레드 환경에서 동기화를 지원하는지 안하는지에 차이점이 존재한다. StringBuffer 는 synchronized 예약어를 사용하여 쓰레드의 동시접근을 막아 멀티쓰레드 환경에서 안정성을 보장하지만 그만큼 속도측면에서 StringBuilder 에 밀린다

2. String 클래스의 indexOf(), substring(), split(), getBytes() 메소드가 어떤 용도로 사용되는지 정리해 주세요
* indexOf() : 특정 문자를 찾아 일치하는 문자의 시작하는 index 값을 return
* substring() : 시작점과 끝점을 입력하여 해당하는 index 의 문자를 return
* split() : 입력한 문자(정규표현식 포함)를 기준으로 문자열을 String[] 로 나누어서 return
* getBytes() : 문자열을 특정 charset 으로 encoding 하여 문자에 해당하는 byte 값을 배열로 return  

3. System 클래스의 주요 용도를 정리해주세요
* 

4. System 클래스에서 여러분들이 절대로 사용해서는 안되는 메소드들은 무엇이고, 그 이유를 정리해주세요
*

5. 제네릭을 사용하는 가장 큰 이유는 무엇인지 정리해주세요
* 생성한 클래스에서 사용할 자료형을 한가지로 통일하여 사용하기위함이다.

6. Set의 용도와 주요 클래스를 정리해 주세요
* 순서에 상관없이 중복되지 않는 자료를 담기위해서 사용하는 자료구조

7. Set의 데이터를 하나씩 꺼내는 방법을 정리해 주세요
* Iterator 객체를 불러와서 꺼낸다.

8. ArrayList와 같은 List와 배열의 차이가 무엇인지 정리해 주세요.
* 배열은 크기가 정해져있는 반면 List는 객체 생성시 지정한 공간이 가득차게 되는경우 자동으로 크기가 조절되므로 따로 작업을 할 필요는 없다.

9. Queue의 용도는 무엇이며, LinkedList의 특징이 무엇인지 정리해 주세요
* Queue 는 먼저들어온 자료가 가장먼저 나오는 FIFO 의 특징을 지닌 자료구조이다.
* LinkedList 는 내부 클래스로 Node를 생성하여 데이터 저장시 nextNode와 prevNode를 사용하여 데이터를 담아주는 자료구조이며, Stack과 Queue의 특징인 LIFO, FIFO 모두 사용할수있는 클래스 이다.

10. Map의 용도와 주요 클래스를 정리해 주세요
* 데이터를 key 와 Value 로 저장하는 자료구조로 순서에 상관없이 저장된다. 주요클래스로는 HashMap이 있으며, 정렬된 map 을 사용하고 싶을때는 TreeMap 클래스를 사용한다.

11. Arrays 클래스의 주요 용도는 무엇인지 정리해 주세요
* 

12. StringTokenizer 클래스의 용도는 무엇인지 정리해 주세요
* 

13. Thread 클래스를 확장한 클래스를 구현할때 항상 만들어야 하는 메소드는 무엇인가요? 접근제어자, 리턴타입, 메소드 이름을 적어주세요
* public void run()

14. Thread 클래스와 Runnable 인터페이스를 구현하여 만든 쓰레드를 실행하려면 각각 어떻게 해야 하는지 정리해 주세요
* Thread 클래스를 Override 하는 쓰레드라면 객체 선언 후 start() 메소드로 실행한다.
* Runnable 인터페이스를 implements 하는 쓰레드라면 객체 선언 후 Thread 객체에 Runnable 객체를 넣어서 start() 메소드로 실행한다.

15. Synchronized에 대해서 정리해 주세요
* 단일 쓰레드 환경의 경우 한 메소드에 하나의 쓰레드만 접근하지만, 멀티 쓰레드 환경의 경우 한 메소드에 여러개의 쓰레드가 접근이 가능하다. 멀티 쓰레드 환경에서 하나의 메소드(혹은 Synchronized 블럭)에는 하나의 쓰레드만 접근 가능하게 해주는 예약어가 synchronized 예약어 이다.

16. InputStream 클래스의 용도는 무엇이고, Reader 클래스와 어떤점이 다른지 정리해 주세요
* 

17. 클래스 선언시 Serializable을 구현하는 이유는 무엇인지 정리해 주세요
* 클래스를 외부 파일로 생성할 시에 클래스 데이터가 값는 고유의 값으로 serialVersionUID 를 설정하여 같은 클래스에 대해서는 같은 정보를 받아오는 역할을 한다. 

18. transient로 선언한 변수는 다른 변수와 어떻게 다른지 정리해 주세요
* Serializable 을 구현한 클래스 내부에서 외부 파일로 내보내면 안되는 변수의 경우 transient 예약어를 통해서 막을 수 있다.

19. TCP 통신을 처리하기 위해서 사용하는 클래스는 무엇인지 정리해 주세요
* Socket 클래스

20. UDP 통신을 처리하기 위해서 사용하는 클래스는 무엇인지 정리해 주세요
* DatagramSocket 클래스