# Introdução aos Padrões de Projeto

Os padrões de projeto são soluções comprovadas para problemas comuns no design de software. Eles são como um catálogo de soluções reutilizáveis que podem ser aplicadas em diferentes contextos. Os padrões de projeto ajudam a tornar o código mais flexível, modular e fácil de manter.

## Classificação dos Padrões de Projeto

Os padrões de projeto são geralmente classificados em três categorias principais:

1. Padrões Criacionais: Esses padrões lidam com a criação de objetos, tornando o sistema independente de como seus objetos são criados, compostos e representados.
  Exemplos: Singleton, Factory Method, Abstract Factory, Builder, Prototype.
2. Padrões Estruturais: Esses padrões se preocupam com a composição de classes ou objetos, permitindo a criação de novas funcionalidades.
  Exemplos: Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy.
3. Padrões Comportamentais: Esses padrões lidam com a comunicação entre objetos e a atribuição de responsabilidades.
  Exemplos: Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Memento, Observer, State, Strategy, Template Method, Visitor.

### Vamos explorar alguns dos padrões mais comuns em Java:

- Singleton
  - Objetivo: Garantir que uma classe tenha apenas uma instância e fornecer um ponto de acesso global a ela.
Exemplo:

``` Java
public class Singleton {
    private static Singleton instance = null;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    // Outros métodos da classe
}
```
- Factory Method
  - Objetivo: Definir uma interface para criar um objeto, mas deixar as subclasses decidirem qual classe instanciar.
Exemplo:
```Java
public abstract class Creator {
    public abstract Product createProduct();
}

public class ConcreteCreator extends Creator {
    public Product createProduct() {
        return new ConcreteProduct();
    }
}

public interface Product {
    // Métodos da interface
}

public class ConcreteProduct implements Product {
    // Implementação dos métodos da interface
}
```
- Decorator
  - Objetivo: Adicionar funcionalidades adicionais a um objeto dinamicamente, sem alterar sua estrutura.
Exemplo:
```Java
public interface Component {
    void operation();
}

public class ConcreteComponent implements Component {
    public void operation() {
        System.out.println("Operação do componente concreto");
    }
}

public abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}

public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();
        System.out.println("Operação adicional do decorador concreto");
    }
}
```

- Observer
  - Objetivo: Definir uma dependência um-para-muitos entre objetos, de modo que quando um objeto muda de estado, todos os seus dependentes são notificados e atualizados automaticamente.
Exemplo:
```Java
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }
}

public interface Observer {
    void update(int state);
}

public class ConcreteObserver implements Observer {
    private int state;

    public void update(int state) {
        this.state = state;
        System.out.println("Observador atualizado com o estado: " + state);
    }
}
```

Esses são apenas alguns exemplos dos padrões de projeto mais comuns em Java. Existem muitos outros padrões, e é importante entender os problemas que cada padrão resolve e quando aplicá-los corretamente em seu projeto. Para conhecer cada um deles, acesse: https://refactoring.guru/pt-br
