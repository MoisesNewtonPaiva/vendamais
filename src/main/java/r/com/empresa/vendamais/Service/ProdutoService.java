package r.com.empresa.vendamais.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import r.com.empresa.vendamais.Entity.Produto;
import r.com.empresa.vendamais.Repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto insertNew(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto editarProduto(Long id, Produto produtoEditado) {

        Produto produtoAtual = findById(id);
        produtoAtual.setNome(produtoEditado.getNome());
        produtoAtual.setQuantidade(produtoEditado.getQuantidade());
        return produtoRepository.save(produtoAtual);
    }

    public Boolean deleteById(Long id) {
        Produto produto = findById(id);
        if (produto != null) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
