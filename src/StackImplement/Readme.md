나만의 Stack 구현하기 :+1: 
--

### 1. Stack의 기능을 생각하며 interface 설계

* push : Stack에 데이터를 담는 메소드
* pop : Stack에 가장 마지막으로 담긴 데이터를 삭제하는 메소드
* peek : Stack에 가장 마지막으로 담긴 데이터를 반환하는 메소드
* size : 현재 Stack의 크기를 반환
* isEmpty : Stack이 비어있음을 확인하는 validation 메소드
* isFull : Stack이 가득 차있음을 확인하는 validation 메소드
* isSmall : Stack의 크기와 데이터의 크기를 일정 기준으로 비교했을때를 확인하는 validation 메소드
* isInArray : 받아온 index의 값이 현재 Stack의 데이터 크기의 범위안에 있는지 확인하는 validation 메소드
* removeAt : 받아온 index에 해당하는 데이터를 삭제하며 뒤에있는 데이터의 위치를 앞으로 이동시키는 메소드


 ### 2. 첫번째 구현 클래스 GenericTenStack
 
 첫번째로 구현한 클래스는 타입 지정이 가능하며 담겨있는 데이터크기의 증감을 10으로 만든 GenericTenStack 이다.
 
 :arrow_right: 우선 데이터를 담을 공간인 T[] data를 선언하였고,   
 :arrow_right: 데이터가 가득찾을시 데이터크기를 증가하는 양을 설정할수 있는 capacityIncrement  
:arrow_right:  현재 데이터의 갯수를 저장하는 dataCount
 
 :arrow_right: 기본생성자로 data의 크기가 10으로 생성되는 생성자를 만들었으며, 사용자의 의도에 따라 초기 데이터 크기와, 데이터 배열 크기 증감을 설정할 수 있다.
 
 * push :    
 data 가 가득찼을 경우(isFull) growCapacity() 메소드가 실행된다.  
 data 에 파라미터가 입력되며 입력된 파라미터를 반환한다.  
    * growCapacity :  
    새롭게 지정되는 데이터의 크기는 현재 데이터의 크기에 지정한 capacityIncrement 와 10을 더해서 완성된다.  
    이때, afterCapacity 의 크기가 Integer 의 최대값을 넘어가는 경우 afterCapacity 는 hugeCapacity() 의 결과값이 된다.   
    Array.copyOf 메소드를 이용해서 증가된 데이터크기를 가지는 배열로 복사한다.    
    
        * hugeCapacity :  
        integer 의 최대값을 넘기는 경우 음수가 되므로 예외를 발생시키고 Integer 의 최대값을 반환한다.
 
 * pop :  
 data 가 비어있는 경우(isEmpty) 예외를 발생시킨다.  
 가장 마지막에 입력된 데이터를 받아온다.  
 removeAt 메소드를 이용해서 가장 마지막에 들어온 데이터를 삭제한다.  
 data 의 갯수가 일정량보다 data 의 크기보다 작은경우(isSmall) decreaseCapacity() 메소드로 데이터 배열의 크기를 줄인다.  
    * removeAt :   
    index 를 파라미터로 받아와서 현재 데이터 크기안에 있는 것을 확인하고(isInArray) 아니라면 예외를 던진다.  
    해당 index를 기준으로 이후에 들어온 데이터들을 앞으로 옮겨준다.  
    마지막에 들어온 데이터를 null로 바꿔주고 data의 갯수를 1 감소시킨다.  
    
    * decreaseCapacity : 
    바뀌는 데이터 크기는 capacityIncrement 와 10을 더한값을 빼준다.  
    Array.copyOf 메소드를 이용해서 감소된 데이터크기를 가지는 배열로 복사한다. 
    
 * peek :  
 data 가 비어있는 경우(isEmpty) 예외를 발생시킨다.
 가장 마지막에 들어온 데이터를 반환한다.
 
 * size :   
 dataCount를 반환하여 현재 담긴 데이터의 수를 반환한다.
 
  ### 3. 두번째 구현 클래스 GenericDoubleStack
  
  두번째로 구현한 클래스는 마찬가지로 타입 지정이 가능하며, 데이터 크기의 증감을 2배로 하는 GenericDoubleStack 이다.  
  
  GenericTenStack 클래스와 차이점만 설명하자면  
  
  * 데이터 크기의 증감이 2배 이므로 사용자가 임의로 지정하는 capacityIncrement 변수는 없앴다.
  * push 메소드 실행 시 데이터 배열이 가득찼을 경우(isFull) growCapacity() 메소드가 실행되며 배열의 크기가 2배로 증가한다.  
  * removeAt 메소드 실행시  System.arraycopy 메소드를 이용하여 newData 배열에 index 이전 영역과 이후 영역을 복사하여 data 배열에 복사한다.
  * isSmall() 메소드의 경우 데이터가 가득찼을 시 두배 증가하므로 절반보다 작을때 true 를 반환하도록 하였다.
  
  
  ### 4. 세번째 구현 클래스 IntegerTenStack
  
  세번째로 구현한 클래스는 타입을 Integer 만 다룰수 있게 하였으며 데이터의 증감은 GenericTenStack 클래스와 일치한다.
  
  GenericTenStack 클래스와 차이점만 설명하자면
  
  * 데이터 증감 크기를 임의로 지정하는 capacityIncrement 변수는 삭제
  * removeAt 메소드 실행시 index 이전 배열과 이후배열 2개를 IntStream을 활용해 합쳐서 data에 복사
   