help:
	@echo '  Usage:'
	@echo '    make <target>'
	@echo
	@echo '  Targets:'
	@echo '    help:   Shows this help'
	@echo '    build:  build site'
	@echo '    watch:  build site host with a development server and rebuild on any change'
	@echo '    clean:  clean generated files'
	@echo '    deploy: depoly to gh-pages'

build: clean
	@java -jar static-app.jar --build

watch:
	@java -jar static-app.jar --watch

clean:
	@rm -rf ./html

deploy: build
	@cd ./html; \
	git init; \
	git add .;\
	git commit -am "Update";\
	git remote add origin git@github.com:rk222ev/dungeons.git;\
	git push origin master:gh-pages -f;
