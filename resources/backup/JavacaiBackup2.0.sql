PGDMP     2                    y            Javacai    13.1    13.1     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16586    Javacai    DATABASE     i   CREATE DATABASE "Javacai" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "Javacai";
                postgres    false            ?            1259    24778    item_id_seq    SEQUENCE     |   CREATE SEQUENCE public.item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 "   DROP SEQUENCE public.item_id_seq;
       public          postgres    false            ?            1259    24780    itens    TABLE       CREATE TABLE public.itens (
    id bigint DEFAULT nextval('public.item_id_seq'::regclass) NOT NULL,
    nome text NOT NULL,
    tipoitem integer NOT NULL,
    quantidade double precision NOT NULL,
    porcao double precision NOT NULL,
    unidadedeentrada character varying(15)
);
    DROP TABLE public.itens;
       public         heap    postgres    false    200            ?            1259    24787    pedido_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.pedido_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 $   DROP SEQUENCE public.pedido_id_seq;
       public          postgres    false            ?            1259    24789    pedidos    TABLE     ~  CREATE TABLE public.pedidos (
    id bigint DEFAULT nextval('public.pedido_id_seq'::regclass) NOT NULL,
    copo_id bigint NOT NULL,
    creme_id bigint,
    acai_id bigint NOT NULL,
    recheio1_id bigint,
    recheio2_id bigint,
    recheio3_id bigint,
    cobertura_id bigint,
    preco double precision NOT NULL,
    datapedido date,
    horariopedido time without time zone
);
    DROP TABLE public.pedidos;
       public         heap    postgres    false    202            ?            1259    24793    precos    TABLE     X   CREATE TABLE public.precos (
    copo_id bigint,
    preco double precision NOT NULL
);
    DROP TABLE public.precos;
       public         heap    postgres    false            ?            1259    24796    usuario_id_seq    SEQUENCE        CREATE SEQUENCE public.usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false            ?            1259    24798    usuarios    TABLE       CREATE TABLE public.usuarios (
    id bigint DEFAULT nextval('public.usuario_id_seq'::regclass) NOT NULL,
    nome text NOT NULL,
    telefone character varying(11) NOT NULL,
    cpf character varying(11) NOT NULL,
    senha text NOT NULL,
    tipousuario integer NOT NULL
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false    205            ?          0    24780    itens 
   TABLE DATA           Y   COPY public.itens (id, nome, tipoitem, quantidade, porcao, unidadedeentrada) FROM stdin;
    public          postgres    false    201   r!       ?          0    24789    pedidos 
   TABLE DATA           ?   COPY public.pedidos (id, copo_id, creme_id, acai_id, recheio1_id, recheio2_id, recheio3_id, cobertura_id, preco, datapedido, horariopedido) FROM stdin;
    public          postgres    false    203   "       ?          0    24793    precos 
   TABLE DATA           0   COPY public.precos (copo_id, preco) FROM stdin;
    public          postgres    false    204   ?"       ?          0    24798    usuarios 
   TABLE DATA           O   COPY public.usuarios (id, nome, telefone, cpf, senha, tipousuario) FROM stdin;
    public          postgres    false    206   ?"       ?           0    0    item_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.item_id_seq', 6, true);
          public          postgres    false    200            ?           0    0    pedido_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.pedido_id_seq', 7, true);
          public          postgres    false    202            ?           0    0    usuario_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuario_id_seq', 1, false);
          public          postgres    false    205            8           2606    24806    itens item_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY public.itens
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);
 9   ALTER TABLE ONLY public.itens DROP CONSTRAINT item_pkey;
       public            postgres    false    201            :           2606    24808    usuarios usuario_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 ?   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuario_pkey;
       public            postgres    false    206            ;           2606    24809    pedidos pedido_acai_id_fkey    FK CONSTRAINT     z   ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedido_acai_id_fkey FOREIGN KEY (acai_id) REFERENCES public.itens(id);
 E   ALTER TABLE ONLY public.pedidos DROP CONSTRAINT pedido_acai_id_fkey;
       public          postgres    false    2872    203    201            <           2606    24814     pedidos pedido_cobertura_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedido_cobertura_id_fkey FOREIGN KEY (cobertura_id) REFERENCES public.itens(id);
 J   ALTER TABLE ONLY public.pedidos DROP CONSTRAINT pedido_cobertura_id_fkey;
       public          postgres    false    201    2872    203            =           2606    24819    pedidos pedido_copo_id_fkey    FK CONSTRAINT     z   ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedido_copo_id_fkey FOREIGN KEY (copo_id) REFERENCES public.itens(id);
 E   ALTER TABLE ONLY public.pedidos DROP CONSTRAINT pedido_copo_id_fkey;
       public          postgres    false    2872    203    201            >           2606    24824    pedidos pedido_creme_id_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedido_creme_id_fkey FOREIGN KEY (creme_id) REFERENCES public.itens(id);
 F   ALTER TABLE ONLY public.pedidos DROP CONSTRAINT pedido_creme_id_fkey;
       public          postgres    false    203    201    2872            ?           2606    24829    pedidos pedido_recheio1_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedido_recheio1_id_fkey FOREIGN KEY (recheio1_id) REFERENCES public.itens(id);
 I   ALTER TABLE ONLY public.pedidos DROP CONSTRAINT pedido_recheio1_id_fkey;
       public          postgres    false    203    201    2872            @           2606    24834    pedidos pedido_recheio2_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedido_recheio2_id_fkey FOREIGN KEY (recheio2_id) REFERENCES public.itens(id);
 I   ALTER TABLE ONLY public.pedidos DROP CONSTRAINT pedido_recheio2_id_fkey;
       public          postgres    false    201    203    2872            A           2606    24839    pedidos pedido_recheio3_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.pedidos
    ADD CONSTRAINT pedido_recheio3_id_fkey FOREIGN KEY (recheio3_id) REFERENCES public.itens(id);
 I   ALTER TABLE ONLY public.pedidos DROP CONSTRAINT pedido_recheio3_id_fkey;
       public          postgres    false    201    2872    203            B           2606    24844    precos precos_copo_id_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY public.precos
    ADD CONSTRAINT precos_copo_id_fkey FOREIGN KEY (copo_id) REFERENCES public.itens(id);
 D   ALTER TABLE ONLY public.precos DROP CONSTRAINT precos_copo_id_fkey;
       public          postgres    false    201    2872    204            ?   ?   x?̽? ???<??h?Z7??A7?Do\Ӣ?/??????,?a??j?"4Zܳhq[ܓ<qv?P???%? '?o?4?v:L?bt???PUolq??3??B\??:?ڹ:?%??'W(?=?a??C	!???'?      ?   s   x?????@D?3?b4?Bjq?udcYV?D??>?AI??)?2?n?FZ????'?	??hh?P엌?ҭ5s?xk~??d4J?s?$??W?Y?7?Xo?xM~?mj#ۖ??]??	??.      ?      x?????? ? ?      ?      x?????? ? ?     