package com.example.travel;

import com.example.travel.model.Place;
import com.example.travel.model.Type;
import com.example.travel.repository.PlaceRepository;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlaceRepositoryTest {
    @Autowired
    private PlaceRepository placeRepository;

    @Test
    public void testFindByTitle() {
        // Создаем тестовую сущность Book
        Place testPlace = new Place();
        Type testType = new Type();
        testType.setType("cafe");

        testPlace.setName("kofi");
        testPlace.setCity("Narva");
        testPlace.setType(testType);
        testPlace.setAddress("Joala 7");
        testPlace.setDescription("good cafe");
        testPlace.setWebsite("https://kofi.ee");


        // Сохраняем тестовую сущность в репозиторий
        placeRepository.save(testPlace);

        // Вызываем метод findByTitle для поиска
        List<Place> foundPlaces = placeRepository.findByName("kofi");

        // Проверяем результат
        assert !foundPlaces.isEmpty();
        assert foundPlaces.size() == 1;
        Place foundPlace = foundPlaces.get(0);
        assert foundPlace.getName().equals("kofi");
        assert foundPlace.getCity().equals("Narva");
        assert foundPlace.getType().equals(testType);
        assert foundPlace.getAddress().equals("Joala 7");
        assert foundPlace.getDescription().equals("good cafe");
        assert foundPlace.getWebsite().equals("https://kofi.ee");
    }
    }