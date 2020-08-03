package cn.yt4j.esdemo.repository;

import cn.yt4j.esdemo.es.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author gyv12
 */
public interface EsProductRespository extends ElasticsearchRepository<Goods, Integer> {

    /**
     * 查询
     * @param name
     * @param brief
     * @param keywords
     * @param detail
     * @param page
     * @return
     */
    Page<Goods> findByNameOrBriefOrKeywordsOrDetail(String name, String brief, String keywords, String detail, Pageable page);
}
