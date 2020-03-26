package shkryl.task9.part3.template_method;


public class Main {
    public static void main(String[] args) {
        MakeEngine engine;

        engine = new EnginePetrol();
        engine.processEngine();
        System.out.println("");

        engine = new EngineGas();
        engine.processEngine();
        System.out.println("");

    }
}
