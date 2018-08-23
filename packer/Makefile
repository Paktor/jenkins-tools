build:
	docker build -t jenkinstools/packer:latest .

push:
	docker push jenkinstools/packer:latest

version:
	docker run -it --rm -u 1000:1000 -v /var/run/docker.sock:/var/run/docker.sock jenkinstools/packer:latest packer --version
