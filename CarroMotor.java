
enum TipoCombustivel {
    GASOLINA, DIESEL, ELETRICO;
}

class Motor {
    private String modelo;
    private int potencia;
    private TipoCombustivel tipoCombustivel;
    private int cilindradas;
    private boolean ligado;
    private int rpm;

    public Motor(String modelo, int potencia, TipoCombustivel tipoCombustivel, int cilindradas) {
        this.modelo = modelo;
        this.potencia = potencia;
        this.tipoCombustivel = tipoCombustivel;
        this.cilindradas = cilindradas;
        this.ligado = false;
        this.rpm = 0;
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            rpm = 1000;
            System.out.println("Motor ligado. RPM inicial: " + rpm);
        }
    }

    public void desligar() {
        if (ligado) {
            ligado = false;
            rpm = 0;
            System.out.println("Motor desligado.");
        }
    }

    public void aumentarPotencia(int incremento) {
        potencia += incremento;
        System.out.println("Potência aumentada para: " + potencia + " cavalos.");
    }

    public void reduzirPotencia(int decremento) {
        if (potencia - decremento >= 0) {
            potencia -= decremento;
            System.out.println("Potência reduzida para: " + potencia + " cavalos.");
        } else {
            System.out.println("Potência não pode ser reduzida abaixo de zero.");
        }
    }

    public void acelerar(int incrementoRpm) {
        if (ligado) {
            rpm += incrementoRpm;
            System.out.println("RPM aumentado para: " + rpm);
        } else {
            System.out.println("Motor está desligado.");
        }
    }

    public void reduzirRpm(int decrementoRpm) {
        if (ligado && rpm - decrementoRpm >= 0) {
            rpm -= decrementoRpm;
            System.out.println("RPM reduzido para: " + rpm);
        } else {
            System.out.println("Motor desligado ou RPM inválido.");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }
}

class Carro {
    private String modelo;
    private Motor motor;

    public Carro(String modelo, Motor motor) {
        this.modelo = modelo;
        this.motor = motor;
    }

    public void ligarCarro() {
        motor.ligar();
        System.out.println("Carro ligado: " + modelo);
    }

    public void desligarCarro() {
        motor.desligar();
        System.out.println("Carro desligado: " + modelo);
    }

    public void turboBoost() {
        motor.aumentarPotencia(50);
    }

    public void reduzirPotenciaMotor() {
        motor.reduzirPotencia(30);
    }

    public void acionarFreio(int decrementoRpm) {
        motor.reduzirRpm(decrementoRpm);
    }

    public void acionarAcelerador(int incrementoRpm) {
        motor.acelerar(incrementoRpm);
    }

    @Override
    public String toString() {
        return "Carro: " + modelo + ", Motor: " + motor.getModelo() + ", Tipo de Combustível: " + motor.getTipoCombustivel();
    }
}

public class Main {
    public static void main(String[] args) {
        Motor motor1 = new Motor("V8", 450, TipoCombustivel.GASOLINA, 5000);
        Motor motor2 = new Motor("V6", 350, TipoCombustivel.DIESEL, 3000);
        Motor motor3 = new Motor("Elétrico", 600, TipoCombustivel.ELETRICO, 0);

        Carro carro1 = new Carro("Mustang", motor1);
        Carro carro2 = new Carro("F-150", motor2);
        Carro carro3 = new Carro("Tesla Model S", motor3);

        System.out.println(carro1);
        System.out.println(carro2);
        System.out.println(carro3);

        carro1.ligarCarro();
        carro1.acionarAcelerador(2000);
        carro1.turboBoost();

        carro2.ligarCarro();
        carro2.acionarFreio(1000);

        carro3.ligarCarro();
        carro3.desligarCarro();
    }
}
