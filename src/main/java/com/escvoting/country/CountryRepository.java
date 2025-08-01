package com.escvoting.country;
import com.escvoting.music.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByCode(String code);
    void deleteByCode(String code);
}
