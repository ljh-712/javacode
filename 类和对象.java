## ��Ͷ���

**1�������������**��***��һ��˼������ķ�ʽ��һ��˼�룬��������⣬��c���Դ����С���⣩��ע�ص��Ƕ���*
**2��oop**:**ָ����==�����������������==��������ѧ��java����һ�����͵�����������ԣ������������ԣ�==�̳��ԣ���̬�ԣ���װ�ԡ�==
**3��ʲô���࣬ʲô�Ƕ���**
      ����˵==�����һ��ģ�壬������������ģ�����������==���������±���ģ����һ���࣬��ͨ��ģ����������±����±���һ��ʵ�壬Ҳ���Ƕ���һ��ģ�ӿ���ʵ�������������󣩡�����==���������ʵ������һ������Բ��������������һ������ͳ��==��
**4������һ����Ͷ������ʵ����**�����е�Ԫ�س�Ϊ����Ա���ԡ����еĺ�����Ϊ����Ա����

```c
class Student {
    public String name;//��Ա����
    public int age;//��Ա����
    public String sex;//��Ա����
    public void study() {//��Ա����
        System.out.println("ѧϰ");
    }
    public void eat() {//��Ա����
        System.out.println("�Է�");
    }
}
public class DemoTest {
    public static void main(String[] args) {
        Student student=new Student();//ʵ����student����
        student.eat();
        student.study();
    }
}
```

1��>==new �ؼ������ڴ���һ�������ʵ������Ҳ����˵newһ������==��
*2��>**ʹ�� **  .    �����ʶ����е����Ժͷ�����*
*3��>ͬһ������Դ������ʵ����*
*5����ĳ�Ա���԰������ֶΡ��������ӿڡ�����飬�ڲ���ȡ�*
*6��>�ֶΣ������ⲿ����ı������������������ⲿ������Щ���ݡ�*

```c
class Person {
    public String name;   // �ֶ�
    public int age; }
class Test {
    public static void main(String[] args) {
        Person person = new Person(); 
         System.out.println(person.name);
        System.out.println(person.age);
    }
 }
��� null   0
```

==����һ��������ֶ����û����ʽ���ó�ʼֵ, ��ô�ᱻ����һ��Ĭ�ϵĳ�ֵ��==���ڸ����������ͣ�Ĭ��ֵΪ0������boolean���ͣ�Ĭ��ֵΪfalse,�����������ͣ��ࡢ���顢String���ȣ�==int/byte/short/long/->0  ��double->0.0d��float->0.0f  char->'\u0000'�� boolean->false����������->null
null ��java�б�ʾһ����Ч�Ķ���������c�����еĿ�ָ�룬�����null���� .   �������ͻ�������ָ���쳣�� java.lang.NullPointerException 
��������ʹ�� . ���ʶ�����ֶ�==

*2��>�����������������Ϊ*

```c
class Student2 {
    public String name="ͥ��";
    public int age=18;
    public void show() {//�����show����һ��չʾ�ķ���
        System.out.println("�ҽ�"+name+"����"+age+"��");
    }
}
public class DemoTest {
    public static void main(String[] args) {
        Student2 student=new Student2();
        student.show();
    }
}
//��ӡ���ҽ�ͥ�����18�ꡣ
Student2 student2=new Student2();
        student2.name="�ŷ�";
        student2.age=888;
        student2.show();
Ҳ���Դ�������ʵ����show��ΪҲ�ᷢ���ı�//��ӡ���ҽ��ŷɽ���888��
```

*3��>static�ؼ���*

~~==�������ԣ�Java��̬���Ժ������, �;����ʵ���޹�. ���仰˵, ͬһ����Ĳ�ͬʵ������ͬһ����̬����==

```c
class Test {
    public int a;
    public static int count;
}
public class DemoTest {
    public static void main(String[] args) {
        Test t=new Test();
        t.a++;
        Test.count++;
        System.out.println(t.a);//1
        System.out.println(Test.count);//1
        Test t2=new Test();
        t2.a++;
        Test.count++;
        System.out.println(t2.a);//1
        System.out.println(Test.count);//2count��һ����̬���ԣ�����ʵ������
   }
```
>��̬��Ա�ķ���ͨ��   ����  .  ����   ��Ҳ����ͨ������  .  ����ȥ���ʣ����ǲ��Ƽ��������б�static���εĲ����Ƿ������ǳ�Ա�����ĵ��û����ֻ��Ҫͨ���������е��á�Ҳ����˵==���б�static���εĲ����Ƿ������ǳ�Ա��������������
��������Ϊʲômain()������static ?--==��Ϊ������Ǿ�̬�ģ���ômain�����ĵ�����Ҫ����==��
>�ھ�̬�������ڲ����ܷ��ʷǾ�̬��Ա��---����Ϊ��̬�ķ����������ڶ��󣬶����Ƿ��������Ӱ����þ�̬���������Ǿ�̬���ݳ�Ա�ĵ��������ڶ��󣬶���ʵ������new��һ�� Test t=new Test();Test���Ƿ��ʾ�̬��==
>���η�����������κη�����Ӧ�� static �ؼ��֣��˷�����Ϊ��̬������
��̬���������࣬����������Ķ��� ����ֱ�ӵ��þ�̬�����������贴�����ʵ���� ��̬�������Է��ʾ�̬���ݳ�Ա�������Ը��ľ�̬���ݳ�Ա��ֵ


>** ��̬������ʵ���޹�, ���Ǻ������. ����⵼�����������:
==��̬��������ֱ��ʹ�÷Ǿ�̬���ݳ�Ա����÷Ǿ�̬����(�Ǿ�̬���ݳ�Ա�ͷ������Ǻ�ʵ����ص�). this��super�����ؼ��ֲ����ھ�̬��������ʹ��(this �ǵ�ǰʵ��������, super�ǵ�ǰʵ������ʵ��������, Ҳ �Ǻ͵�ǰʵ�����).==

```c
class Person {
     public int age;//ʵ������    ����ڶ�����
     public String name;//ʵ������
     public String sex;//ʵ������ 
    public static int count;//�����Ҳ�о�̬������
    ����ʱ�Ѿ������������౾����ֻ��һ�ݡ�����ڷ�����
     public final int SIZE = 10;//��final���εĽг���
     ��Ҳ���ڶ��� ��final���Σ��������ɸ��ģ�����ڷ�����
     public static final int  COUNT = 99;//��̬�ĳ����������౾��ֻ��һ��  ��final���Σ��������ɸ���     //ʵ����Ա����          public void eat() {
        int a = 10;//�ֲ�����
         System.out.println("eat()!");
       }
     //ʵ����Ա����
      public void sleep() {
        System.out.println("sleep()!");
       } 
    //��̬��Ա����
      public static void staticTest(){ 
         //���ܷ��ʷǾ�̬��Ա
         //sex = "man"; error 
        System.out.println("StaticTest()");
      }
 } public class Main{  public static void main(String[] args) { 
        //�������� ʵ��������        
 Person person = new Person();//personΪ���������
         System.out.println(person.age);//Ĭ��ֵΪ0
         System.out.println(person.name);//Ĭ��ֵΪnull 
        //System.out.println(person.count);//���о���! 
        //��ȷ���ʷ�ʽ��         System.out.println(Person.count);
         System.out.println(Person.COUNT);
         Person.staticTest();
         //�ܽ᣺���б�static�����εķ����������ԣ�ȫ���������ڶ���
         person.eat(); 
        person.sleep();
   }
 } 
```

**5����װ*****��***��װ�ı��ʾ�������ĵ����߲���̫����˽����ʵ���������ʵ�����, ֻҪ֪�����ʹ���������. ������==��������ʹ���ߵ�ѧϰ��ʹ�óɱ�, �Ӷ������˸��ӳ̶�.==
*1> privateʵ�ַ�װ*

```c
class Student {
    private String name="����";
    private int age;//ʹ�� private ��װ����, ���ṩ public ��������ĵ�����ʹ��
    public void show() {//�ֶ��Ѿ�ʹ�� private ������. ��ĵ�����(main������)����ֱ��ʹ��. ����Ҫ���� show ����
        System.out.println(name);
    }
}
    public static void main(String[] args) {
        Student student=new Student();
        student.name="uu";name��˽�����ݣ�����ֱ�ӷ���
        System.out.println(name);
        student.show();
    }
}
```
>��ʱ�ֶ��Ѿ�ʹ�� private ������. ��ĵ�����(main������)����ֱ��ʹ��. ����Ҫ���� show ����. ��ʱ���ʹ ���߾Ͳ����˽� Person ���ʵ��ϸ��. ͬʱ������ʵ�����޸����ֶε�����, ��ĵ����߲���Ҫ�����κ��޸�(��ĵ����߸������ʲ��� name, age �������ֶ�). 
private �����������ֶ�, Ҳ�����η��� ͨ����������ǻ���ֶ���Ϊ private ����, ���Ƿ����Ƿ���Ҫ��Ϊ public, ����Ҫ�Ӿ������ζ���.
2>������ʹ�� private �������ֶε�ʱ��, ���޷�ֱ��ʹ������ֶ���.��������Ӧ��ʹ��getter/setter������idea��ݼ�����alt+insert    ����shift�ɶ�ѡ��

```c

class Student {
    private String name;
    private int age;

    public String getName() {//getName ��Ϊ getter ����, ��ʾ��ȡ�����Ա��ֵ
        return name;
    }

    public void setName(String name) {//setName ��Ϊ getter ����, ��ʾ�޸������Ա��ֵ
        this.name = name;//this���ã���ʾ���ø÷����Ķ���
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;//this���ã���ʾ���ø÷����Ķ���
    }
    public void show() {
        System.out.println(name+age);
    }
}

public class DemoTest {
    public static void main(String[] args) {
        Student student=new Student();
        student.setName("ͥ��");
        student.setAge(19);
        String name=student.getName();
        int age=19;
        System.out.println(name);
        System.out.println(age);
        student.show();
    }
```
![���������ͼƬ����](https://img-blog.csdnimg.cn/20191023131157138.png)
**==ע�����������˽�еģ��Ͳ���ֱ���� . �����������Ҫ��ȡ�����޸���� private ����, ����Ҫʹ�� getter / setter ����==. 
**==�ֶ� vs ����==
>����ͨ����������ݳ�Ա��Ϊ "�ֶ�(?eld)" , ������ֶ�ͬʱ�ṩ�� getter / setter ����, ��ô����Ҳ���Խ��� ��Ϊ "����(property )"


**5�����췽����** ʹ�ùؼ���newʵ�����¶���ʱ�ᱻ�Զ�����,== ������ɳ�ʼ������. ������������һ����û�з���ֵ==��
*1��>�����ʵ��һ����ʱ==û��д���췽��==����ô��������==�Զ�����һ���޲ι��췽��==�����ǣ�������Լ�д��һ�����췽������ô�������������Զ����ɡ�*
```c
class Person {
    private int age;
    private String name;

    public Person() {//Ĭ�Ϲ��췽��
        this.name = "xx";
        this.age = 15;
    }
    public Person(String name,int age) {//���������Ĺ��췽��
        this.name=name;
        this.age=age;
    }
    public void show() {
        System.out.println(name+age);
    }
}


public class DemoTest {
    public static void main(String[] args) {
        Person person =new Person();//���õ�һ�����췽��
        //System.out.print(person);
        person.show();
        Person person1=new Person("lim",15);//���õڶ������췽��
        person1.show();
    }
```

*2��>**this�ؼ���*
==this����ǰ���������==
>ΪʲĪ˵this�ǵ�ǰ��������ã�
>==����Ĵ�������������һ�������ڴ�ռ䣬�ڶ������ù��캯���������this˵����ǰ����û�й����==

```c
class Person {
    private String name;
    private int age;
    private String sex;

    public Person() {
        //System.out.println();
        this("xiao",15,"Ů");//������ڵ�һ����ʾ
    }
    public Person(String name,int age,String sex) {
        this.name=name;
        this.age=age;
        this.sex=sex;
    }
    public void show() {
        System.out.println(name+age+sex);
    }
}
public class DemoTest {
    public static void main(String[] args) {
        Person person=new Person();
        person.show();
    }
}
```
**6. �����**
>ʹ�� {} �����һ�δ���.
���ݴ���鶨���λ���Լ��ؼ��֣��ֿɷ�Ϊ�������֣�

>��ͨ����� ���������ڷ����еĴ����




>����飺���������еĴ����(�������η�)��Ҳ�У�ʵ������顣��������һ�����ڳ�ʼ��ʵ����Ա������

> ��̬��


==��̬�����ִ��������ʵ������顢ʵ�������ִ�������ڹ��췽���������һ����̬����飬һ����̬���ԣ�˭��ǰ˭��ִ��==

```java
class Person{
    private String name;
    private int age;
    public static int count = 10;

    //��̬�����-����ʼ�� ��̬�����ݳ�Ա
    static {
        count = 9999999;
        //this.name = "chang";
        System.out.println("static{}");
    }

    //ʵ������� --�� ��ʼ�����ʵ�����ݳ�Ա
    {
        this.name = "caocao";
        this.age = 99;
        //count = 8888;
        System.out.println("instance{}");
    }
```

**## 7����������**

>����ֻ�Ǳ�ʾû�����ֵĶ���. û�����õĶ����Ϊ��������. ��������ֻ���ڴ�������ʱʹ��. ���һ������ֻ����һ��, ���治��Ҫ����, ���Կ���ʹ����������.

```java
class Person {
     private String name;     
     private int age;    
     public Person(String name,int age) {         
     this.age = age;         
     this.name = name;     
     }     
     public void show() {         
     System.out.println("name:"+name+" " + "age:"+age);     } } 
 
public class Main { 
 
    public static void main(String[] args) {         
    new Person("caocao",19).show();//ͨ������������÷���     
    } 
 } 
 
// ִ�н�� name��caocao age��1
```

