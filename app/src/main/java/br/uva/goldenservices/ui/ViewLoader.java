package br.uva.goldenservices.ui;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.uva.goldenservices.MainActivity;
import br.uva.goldenservices.R;
import br.uva.goldenservices.ui.adapters.AnuncioAdapter;
import golden.services.http.ConnectorWebService;
import golden.services.model.anuncios.Anuncio;
import golden.services.model.anuncios.ListaAnuncios;
import golden.services.model.usuarios.Usuario;

/**
 * Created by caio on 30/05/16.
 */
public class ViewLoader {
    public static void initialize(int id) {
        if(id != R.layout.login && id != R.layout.cadastrousuario) {
            Usuario usuarioLogado = ConnectorWebService.getUsuarioLogado();
            Helper.setUsuarioConectado(usuarioLogado);
            if (usuarioLogado == null) {
                Helper.changeView(R.layout.login);
            } else if (id == R.layout.telainiciallogado) {
                TextView label = (TextView) Helper.getActivity().findViewById(R.id.telaInicialLogadoUsuarioConectado);
                label.setText(usuarioLogado.getEmail() + " " + usuarioLogado.getNome());
            }else if(id == R.layout.listar_servicos){
                AnuncioAdapter m_adapter;
                ListaAnuncios listaAnuncio = ConnectorWebService.listarAnuncio();
                List<Anuncio> m_parts =  listaAnuncio.getListaAnuncios();
                m_adapter = new AnuncioAdapter(Helper.getActivity(),R.layout.listar_servicos, m_parts);


                ListView lista  = (ListView) Helper.getActivity().findViewById(R.id.listAnuncio);
                TextView teste = (TextView) Helper.getActivity().findViewById(R.id.Teste);


                //if(listaAnuncio != null && listaAnuncio.getListaAnuncios() != null) {
                    lista.setAdapter(new AnuncioAdapter(Helper.getActivity(), android.R.layout.simple_list_item_1, m_parts));
                    teste.setText(m_parts.get(16).getAreaDeAtuacao());
                //}

            }
        }
    }
}
