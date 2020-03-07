package pl.venustus.CarsToDB;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class CarGui extends VerticalLayout {

    private TextField textFieldId;
    private TextField textFieldMark;
    private TextField textFieldModel;
    private TextField textFieldColor;
    private Button button;
    private CarDao carDao;

    @Autowired
    public CarGui(CarDao carDao) {
        this.textFieldId = new TextField("id ");
        this.textFieldMark = new TextField("Mark ");
        this.textFieldModel = new TextField("Model ");
        this.textFieldColor = new TextField("Color ");
        this.button = new Button("Przycisk ");
        this.carDao = carDao;

        button.addClickListener(ClickEvent -> {
            Car car = new Car(Long.parseLong(textFieldId.getValue()), textFieldMark.getValue(), textFieldModel.getValue(), textFieldColor.getValue());
            carDao.addCar(car);
        });

        add(textFieldId, textFieldMark, textFieldModel, textFieldColor, button);

    }

}
