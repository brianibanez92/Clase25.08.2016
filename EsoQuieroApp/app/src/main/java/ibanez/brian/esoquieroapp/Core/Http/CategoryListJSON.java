package ibanez.brian.esoquieroapp.Core.Http;

import java.util.List;

/**
 * Created by brian.ibanez on 06/11/2016.
 */
public class CategoryListJSON
{
    public boolean error;
    public List<CategoryJSON> categorias;

    private CategoryListJSON()
    {
    }


    /*
    {"error": false
        "categorias": [3]
        0: {"id": 1
        "titulo": "nueva categoria2"
        "desc": "Esto es lo que quiero q funcione.!!!!"
        "url_foto": null
        "createdAt": "2016-10-18 18:16:10"
    } */

}
