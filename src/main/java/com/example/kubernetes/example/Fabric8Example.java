package com.example.kubernetes.example;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.kubernetes.client.proto.Meta;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuhaozhen
 * @version Revision 1.0.0
 * @date 2019/9/19 13:57
 */
@Slf4j
public class Fabric8Example {

    private static final String DEFAULT_URL = "http://136.244.85.148:8080";

    public static void main(String[] args) {

        Config config = new ConfigBuilder().withMasterUrl(DEFAULT_URL).build();
        KubernetesClient client = new DefaultKubernetesClient(DEFAULT_URL);//使用默认的就足够了
        insert(client);


    }

    private static void testNamespace() {
        Namespace namespace = new Namespace();
        //namespace.setApiVersion(Meta.APIVersions.VERSIONS_FIELD_NUMBER);
        namespace.setKind("namespace");
        ObjectMeta objectMeta = new ObjectMeta();
        objectMeta.setName("nc-f8");
        namespace.setMetadata(objectMeta);

    }


    private static void insert(KubernetesClient client) {
        //创建：
        Service service = client.services().inNamespace("my-nginx").create();
    }

    private static void update(KubernetesClient client) {
        //更新：
        Namespace namespace = client.namespaces().withName("test").get();
        //update resources
        client.namespaces().createOrReplace(namespace);
    }

    private static void query(KubernetesClient client) {
        //查询：
        ServiceList services = client.services().inNamespace("default").list();
        Service service1 = client.services().inNamespace("default").withName("myservice").get();
    }

    private static void delete(KubernetesClient client) {
        //删除：
        client.services().inNamespace("default").withName("myservice").delete();
    }
}
