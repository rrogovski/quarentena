INSERT INTO AUTOR(nome, nascimento, nacionalidade) VALUES('Autor 01', '1980-01-01 00:00:00', 'BR');
INSERT INTO AUTOR(nome, nascimento, nacionalidade) VALUES('Autor 02', '1980-01-01 00:00:00', 'RU');
INSERT INTO AUTOR(nome, nascimento, nacionalidade) VALUES('Autor 03', '1980-01-01 00:00:00', 'CH');

INSERT INTO LIVRO(nome, autor_id, publicacao, editora, resumo) VALUES('Livro 1', 1, '2020-01-01 00:00:00', 'Editora 01', 'Resumo do livro 01');
INSERT INTO LIVRO(nome, autor_id, publicacao, editora, resumo) VALUES('Livro 2', 2, '2020-01-01 00:00:00', 'Editora 02', 'Resumo do livro 02');
INSERT INTO LIVRO(nome, autor_id, publicacao, editora, resumo) VALUES('Livro 3', 3, '2020-01-01 00:00:00', 'Editora 03', 'Resumo do livro 03');

INSERT INTO COMENTARIO(data, texto, usuario, livro_id) VALUES('2020-01-01 00:00:00','Comentário do livro 01', 'usuario 01', 1);
INSERT INTO COMENTARIO(data, texto, usuario, livro_id) VALUES('2020-01-01 00:00:00','Comentário do livro 01', 'usuario 02', 1);
INSERT INTO COMENTARIO(data, texto, usuario, livro_id) VALUES('2020-01-01 00:00:00','Comentário do livro 02', 'usuario 01', 2);