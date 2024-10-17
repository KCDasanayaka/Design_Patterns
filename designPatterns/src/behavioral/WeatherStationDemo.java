package behavioral;

import java.util.ArrayList;
import java.util.List;

// Subject (Weather Station)
class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

// Observer Interface
interface WeatherObserver {
    void update(int temperature);
}

// Concrete Observer: DisplayDevice
class DisplayDevice implements WeatherObserver {
    private String name;

    public DisplayDevice(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " received temperature update: " + temperature + "°C");
    }
}

// Concrete Observer: MobileApp
class MobileApp implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Mobile App received temperature update: " + temperature + "°C");
    }
}

// Client
public class WeatherStationDemo {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        DisplayDevice display1 = new DisplayDevice("Display 1");
        DisplayDevice display2 = new DisplayDevice("Display 2");
        MobileApp mobileApp = new MobileApp();

        weatherStation.addObserver(display1);
        weatherStation.addObserver(display2);
        weatherStation.addObserver(mobileApp);

        weatherStation.setTemperature(25);  // Output: Display 1 received temperature update: 25°C
        //         Display 2 received temperature update: 25°C
        //         Mobile App received temperature update: 25°C

        weatherStation.setTemperature(30);  // Output: Display 1 received temperature update: 30°C
        //         Display 2 received temperature update: 30°C
        //         Mobile App received temperature update: 30°C
    }
}

