```mermaid
gantt
dateFormat  YYYY-MM-DD
title Adding GANTT diagram to mermaid
excludes weekdays 2014-01-10

section A section
Completed task            :done,    des1, 2014-01-06,2014-01-08
Active task               :active,  des2, 2014-01-09, 3d
Future task               :         des3, after des2, 5d
Future task2               :         des4, after des3, 5d
```

```mermaid
sequenceDiagram
    participant Alice
    participant Bob
    participant John
    
    Alice->>John: Hello John, how are you?
    
    loop Healthcheck
        John->>John: Fight against hypochondria
    end
    
    Note right of John: Rational thoughts <br/>prevail!
    John-->>Alice: Great!
    John->>Bob: How about you?
    Bob-->>John: Jolly good!
```

```mermaid
classDiagram
      Animal <|-- Duck
      Animal <|-- Fish
      Animal <|-- Zebra
      Animal : int age
      Animal : String gender
      Animal: isMammal()
      Animal: mate()
      class Duck{
          String beakColor
          swim()
          quack()
      }
      class Fish{
          int sizeInFeet
          canEat()
      }
      class Zebra{
          bool is_wild
          run()
          eat()
      }
```

```mermaid
graph RL;
    A:::someclass-->B;
    A-->C;
    B-->D;
    C-->D;
    classDef someclass fill:#f96;
```