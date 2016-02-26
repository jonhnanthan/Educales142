__author__ = 'leonardo'


@auth.requires_login()
def index():
    return dict()


@auth.requires_login()
def multi_choice():
    print(request.vars)
    # print(auth.user.username)
    if request.vars:
        corpo = {'Tipo': 'MULTIPLE_CHOICE_EXERCISE',
                 'Alternativa3': request.vars.Alternativa3,
                 'Alternativa2': request.vars.Alternativa2,
                 'Alternativa1': request.vars.Alternativa1,
                 'Resposta': request.vars.Resposta,
                 'Pergunta': request.vars.Pergunta,
                 'Professor':auth.user.email}
        # print(auth.user.username)
        form = SQLFORM(db.atividade)
        form.vars.nome = request.vars.Nome
        form.vars.tipo = db(db.tipo_atividade.nome == "MULTIPLE_CHOICE_EXERCISE").select()[0].id
        form.vars.pasta = request.vars.Pasta
        form.vars.corpo = str(corpo)
        form.vars.professor = db(db.auth_user.email == auth.user.email).select()[0].id
        id = db.atividade.insert(**dict(form.vars))
        response.flash = 'Atividade Salva com Sucesso'

    return dict()


@auth.requires_login()
def color_match():
    print(request.vars)
    # print(auth.user.username)
    if request.vars:
        corpo = {'Tipo': 'COLOR_MATCH_EXERCISE',
                 'Alternativa3': request.vars.Alternativa3,
                 'Alternativa2': request.vars.Alternativa2,
                 'Alternativa1': request.vars.Alternativa1,
                 'Resposta': request.vars.Color,
                 'Pergunta': request.vars.Pergunta,
                 'Professor':auth.user.email}
        # print(auth.user.username)
        form = SQLFORM(db.atividade)
        form.vars.nome = request.vars.Nome
        form.vars.tipo = db(db.tipo_atividade.nome == "MULTIPLE_CHOICE_EXERCISE").select()[0].id
        form.vars.pasta = request.vars.Pasta
        form.vars.corpo = str(corpo)
        form.vars.professor = db(db.auth_user.email == auth.user.email).select()[0].id
        id = db.atividade.insert(**dict(form.vars))
        response.flash = 'Atividade Salva com Sucesso'

    return dict()


@auth.requires_login()
def image_match():

    if request.vars:
        corpo = {'Tipo': 'IMAGE_MATCH_EXERCISE',
                 'Resposta': request.vars.Resposta,
                 'Imagem':request.vars.Image,
                 'Pergunta': request.vars.Pergunta,
                 'Professor':auth.user.email}
        # print(auth.user.username)
        form = SQLFORM(db.atividade)
        form.vars.nome = request.vars.Nome
        form.vars.tipo = db(db.tipo_atividade.nome == "MULTIPLE_CHOICE_EXERCISE").select()[0].id
        form.vars.pasta = request.vars.Pasta
        form.vars.corpo = str(corpo)
        form.vars.professor = db(db.auth_user.email == auth.user.email).select()[0].id
        id = db.atividade.insert(**dict(form.vars))
        response.flash = 'Atividade Salva com Sucesso'

    return dict()


@auth.requires_login()
def multi_choice2():
    print(request.vars)
    # print(auth.user.username)
    if request.vars:
        corpo = {'Tipo': 'MULTIPLE_CORRECT_CHOICE_EXERCISE',
                 'Alternativa3': {request.vars.Alternativa3: request.vars.Correta3 or "0"},
                 'Alternativa2': {request.vars.Alternativa2: request.vars.Correta2 or "0"},
                 'Alternativa1': {request.vars.Alternativa1: request.vars.Correta1 or "0"},
                 'Alternativa0': {request.vars.Alternativa0: request.vars.Correta0 or "0"},
                 'Pergunta': request.vars.Pergunta,
                 'Professor':auth.user.email}
        # print(auth.user.username)
        form = SQLFORM(db.atividade)
        form.vars.nome = request.vars.Nome
        form.vars.tipo = db(db.tipo_atividade.nome == "MULTIPLE_CORRECT_CHOICE_EXERCISE").select()[0].id
        form.vars.pasta = request.vars.Pasta
        form.vars.corpo = str(corpo)
        form.vars.professor = db(db.auth_user.email == auth.user.email).select()[0].id
        id = db.atividade.insert(**dict(form.vars))
        response.flash = 'Atividade Salva com Sucesso'

    return dict()


@auth.requires_login()
def complete():
    print(request.vars)
    print(auth.user.email)
    if request.vars:
        corpo = {'Tipo': 'COMPLETE_EXERCISE',
                 'Palavra': request.vars.Palavra,
                 'Resposta': request.vars.Resposta,
                 'Professor':auth.user.email}
        # print(auth.user.username)
        form = SQLFORM(db.atividade)
        form.vars.nome = request.vars.Nome
        form.vars.tipo = db(db.tipo_atividade.nome == "COMPLETE_EXERCISE").select()[0].id
        form.vars.pasta = request.vars.Pasta
        form.vars.corpo = str(corpo)
        form.vars.professor = db(db.auth_user.email == auth.user.email).select()[0].id
        print(form.vars)
        id = db.atividade.insert(**dict(form.vars))
        response.flash = 'Atividade Salva com Sucesso'

    return dict()


@auth.requires_login()
def reports():
    return dict()
