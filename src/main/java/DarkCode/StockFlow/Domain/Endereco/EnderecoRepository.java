package DarkCode.StockFlow.Domain.Endereco;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Override
    Page<Endereco> findAll(Pageable pageable);
}
