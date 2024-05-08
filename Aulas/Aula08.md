# Aula 8 - Modificadores de acesso, métodos e atributos estáticos, objetos como parâmetros, métodos que retornam objetos

### Modificadores de acesso

Os modificadores de acesso são palavras-chave que definem o nível de acesso aos membros (atributos e métodos) de uma classe. Os três principais modificadores de acesso são:
- public: os membros públicos podem ser acessados de qualquer lugar, tanto dentro como fora da classe.
- private: os membros privados só podem ser acessados de dentro da própria classe. Eles não são visíveis para outras classes.
- protected: os membros protegidos têm um nível de acesso intermediário. Eles podem ser acessados dentro da própria classe, em subclasses (herança) e em classes no mesmo pacote.

### Modificadores de Método
- abstract: Um método abstrato não possui implementação na classe em que é declarado. Ele deve ser implementado nas subclasses.
- final: Um método final não pode ser sobrescrito em subclasses. Ele mantém a implementação definida na classe em que é declarado.

### Atributos e Métodos Estáticos (static)
Atributos e métodos estáticos pertencem à classe em vez de pertencerem a instâncias individuais (objetos) da classe. Eles podem ser acessados diretamente usando o nome da classe, sem a necessidade de criar uma instância.
- Atributo estático: É compartilhado por todas as instâncias da classe. Pode ser acessado usando o nome da classe, seguido pelo nome do atributo.
- Método estático: Não requer uma instância da classe para ser invocado. Pode ser acessado usando o nome da classe, seguido pelo nome do método.
### Objetos como Parâmetros
É possível passar objetos como parâmetros para métodos. Isso permite que os métodos manipulem e interajam com os objetos fornecidos como argumentos.
### Métodos que Retornam Objetos
Assim como métodos podem receber objetos como parâmetros, eles também podem retornar objetos como resultado. Isso permite que os métodos criem e retornem novas instâncias de objetos.

# Autoincremento
