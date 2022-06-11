package shortUrl.shortUrl.domain.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import shortUrl.shortUrl.domain.value.Algorithm;

import javax.persistence.*;

@Entity
@Table(name = "url")
@Getter
@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String originalUrl;

    private String shortUrl;

    private Long hits;

    private Algorithm algorithm;

    public Url(String originalUrl, Algorithm algorithm) {
        this.originalUrl = originalUrl;
        this.algorithm = algorithm;
        this.hits = 0L;
    }

    public void hitCount() {
        this.hits += 1;
        log.info("조회 수 1 증가.");
    }

    public void saveShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
        log.info("shortUrl => {} 저장.", shortUrl);
    }
}